package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystem.base.BaseConstants;

public class DriverControls {
    private static CommandXboxController controller = new CommandXboxController(0);

    public static void bind() {
        controller.leftTrigger().whileTrue(RobotContainer.proximalJoint.spinAt(BaseConstants.MAX_SPEED));
        controller.rightTrigger().whileTrue(RobotContainer.proximalJoint.spinAt(BaseConstants.MAX_SPEED.times(-1)));
    }
}
