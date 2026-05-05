package frc.robot.subsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.HandPlacement;
import frc.robot.RobotContainer;

public class Superstructure {
    public Command applyPlacement(HandPlacement placement) {
        return Commands.sequence(
            RobotContainer.base.moveTo(placement.baseRotation),
            RobotContainer.proximalJoint.moveTo(placement.proximalAngle),
            RobotContainer.distalJoint.moveTo(placement.distalAngle)
        );
    }

    public Command stow() {
        return applyPlacement(HandPlacement.zero());
    }
}
