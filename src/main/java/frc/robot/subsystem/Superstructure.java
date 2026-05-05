package frc.robot.subsystem;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.HandPlacement;
import frc.robot.RobotContainer;

public class Superstructure {
    public static final HandPlacement INTAKE = new HandPlacement(
        Degrees.of(0.0),
        Degrees.of(90.0),
        Degrees.of(90.0)
    );
    
    public Command applyPlacement(HandPlacement placement) {
        return Commands.sequence(
            RobotContainer.base.setAngle(placement.baseRotation),
            RobotContainer.proximalJoint.setAngle(placement.proximalAngle),
            RobotContainer.distalJoint.setAngle(placement.distalAngle)
        );
    }
}
