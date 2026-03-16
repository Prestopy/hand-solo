package frc.robot.subsystem.joints;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Joints extends SubsystemBase {
    private JointsIO io;

    public Joints(JointsIO io) {
        this.io = io;
    }

    public Command setAngle(Angle angle) {
        return runEnd(
            () -> io.moveTo(angle),
            () -> io.stop()
        );
    }

    public Command stop() {
        return runOnce(() -> io.stop());
    }
}
