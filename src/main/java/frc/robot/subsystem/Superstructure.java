package frc.robot.subsystem;

import static frc.robot.RobotContainer.base;
import static frc.robot.RobotContainer.distalJoint;
import static frc.robot.RobotContainer.proximalJoint;

import java.util.Set;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.HandPlacement;
import frc.robot.RobotContainer;
import frc.robot.Walmart;

public class Superstructure {
    private static Superstructure instance;

    private static final Walmart currentWalmart = new Walmart();
    private static HandPlacement currentPlacement = currentWalmart.calculateConfiguration();

    public static Superstructure getInstance() {
        if (instance == null) {
            instance = new Superstructure();
        }
        return instance;
    }

    public void setTarget(Translation3d target) {
        currentWalmart.withPosition(target);
        currentPlacement = currentWalmart.calculateConfiguration();
    }

    public void nudge(Translation3d delta) {
        currentWalmart.add(delta);
        currentPlacement = currentWalmart.calculateConfiguration();
    }

    public Command moveToTarget() {
        return Commands.defer(() -> Commands.parallel(
            RobotContainer.base.moveTo(currentPlacement.baseRotation),
            RobotContainer.proximalJoint.moveTo(currentPlacement.proximalAngle),
            RobotContainer.distalJoint.moveTo(currentPlacement.distalAngle)
        ), Set.of(base, proximalJoint, distalJoint));
    }

    public Command followTarget() {
        return Commands.parallel(
            RobotContainer.base.follow(() -> currentPlacement.baseRotation),
            RobotContainer.proximalJoint.follow(() -> currentPlacement.proximalAngle),
            RobotContainer.distalJoint.follow(() -> currentPlacement.distalAngle)
        );
    }
}
