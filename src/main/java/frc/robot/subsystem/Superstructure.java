package frc.robot.subsystem;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.HandPlacement;
import frc.robot.RobotContainer;

public class Superstructure {
    public Command applyPlacement(HandPlacement placement) {
        return Commands.sequence(
            RobotContainer.base.setAngle(placement.baseRotation),
            RobotContainer.proximalJoint.setAngle(placement.proximalAngle),
            RobotContainer.distalJoint.setAngle(placement.distalAngle)
        );
    }

    public Command stow() {
        return applyPlacement(HandPlacement.zero());
    }
}
