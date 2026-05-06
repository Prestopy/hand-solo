package frc.lib;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem<T extends MotorIO> extends SubsystemBase {
    private T io;

    public MotorSubsystem(T io) {
        this.io = io;
    }

    public Command moveTo(Angle angle) {
        return runOnce(() -> io.moveTo(angle));
    }

    public Command follow(Supplier<Angle> angleSupplier) {
        return run(() -> io.moveTo(angleSupplier.get()));
    }

    public Command spinAt(AngularVelocity speed) {
        return runEnd(() -> io.spinAt(speed), () -> io.stop());
    }

    public Command stop() {
        return runOnce(() -> io.stop());
    }
}
