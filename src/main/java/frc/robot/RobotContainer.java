// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystem.Superstructure;
import frc.robot.subsystem.base.Base;
import frc.robot.subsystem.base.BaseConstants;
import frc.robot.subsystem.claw.Claw;
import frc.robot.subsystem.joint.Joint;
import frc.robot.subsystem.joint.JointConstants;
import frc.robot.subsystem.joint.JointIOReal;
import frc.robot.subsystem.joint.JointIOSim;

public class RobotContainer {
  public static final String CANBUS = "canaaronlockin";

  public static Base base;
  public static Joint proximalJoint;
  public static Joint distalJoint;
  public static Claw claw;

  private static CommandXboxController controller = new CommandXboxController(0);

  public static final SlewRateLimiter slewRate = new SlewRateLimiter(RobotConstants.slewRate.in(MetersPerSecondPerSecond));

  public static final Command defaultCommand = 
    Superstructure.getInstance()
        .followTarget()
        .alongWith(Commands.run(() -> {
          Superstructure.getInstance().nudge(
            new Translation3d(
              slewRate.calculate(-controller.getLeftY()
						    * RobotConstants.maxSpeed.in(MetersPerSecond)), 
              slewRate.calculate(-controller.getLeftX()
                * RobotConstants.maxSpeed.in(MetersPerSecond)),
              slewRate.calculate(-controller.getRightY()
                * RobotConstants.maxSpeed.in(MetersPerSecond))
            )
          );
        }));

  public RobotContainer() {
    if (RobotBase.isReal()) {
      proximalJoint = new Joint(new JointIOReal(JointConstants.Configurations.PROXIMAL_ARM));
      distalJoint   = new Joint(new JointIOReal(JointConstants.Configurations.DISTAL_ARM));
    } else {
      proximalJoint = new Joint(new JointIOSim(JointConstants.Configurations.PROXIMAL_ARM));
      distalJoint   = new Joint(new JointIOSim(JointConstants.Configurations.DISTAL_ARM));
    }

    configureBindings();

    // Schedule the default command for the superstructure
    defaultCommand.schedule();
  }

  private void configureBindings() {
    controller.leftTrigger().whileTrue(RobotContainer.proximalJoint.spinAt(BaseConstants.MAX_SPEED));
    controller.rightTrigger().whileTrue(RobotContainer.proximalJoint.spinAt(BaseConstants.MAX_SPEED.times(-1)));

    controller.x().onTrue(Commands.runOnce(() -> RobotContainer.defaultCommand.schedule()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
