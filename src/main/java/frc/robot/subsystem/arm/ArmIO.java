package frc.robot.subsystem.arm;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface ArmIO {    
    Angle getAngle();
    void spin(AngularVelocity speed);
    void moveTo(Angle setpoint);
    void stop();
}
