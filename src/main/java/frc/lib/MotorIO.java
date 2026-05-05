package frc.lib;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface MotorIO {
    Angle getAngle();
    void moveTo(Angle setpoint);
    void spinAt(AngularVelocity speed);
    void stop();
}
