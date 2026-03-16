// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.robot.subsystem.base.Base;
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

  public RobotContainer() {
    if (RobotBase.isReal()) {
      proximalJoint = new Joint(new JointIOReal(JointConstants.Configurations.PROXIMAL_ARM));
      distalJoint   = new Joint(new JointIOReal(JointConstants.Configurations.DISTAL_ARM));
    } else {
      proximalJoint = new Joint(new JointIOSim(JointConstants.Configurations.PROXIMAL_ARM));
      distalJoint   = new Joint(new JointIOSim(JointConstants.Configurations.DISTAL_ARM));
    }

    configureBindings();
  }

  private void configureBindings() {
    if (RobotBase.isReal()) {
      DriverControls.bind();
    } else {
      SimulationControls.bind();
    }
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
