package frc.robot.subsystem.base;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface BaseIO {    
    Angle getAngle();
    void moveTo(Angle setpoint);
    void spin(AngularVelocity speed);
    void stop();
}
    

