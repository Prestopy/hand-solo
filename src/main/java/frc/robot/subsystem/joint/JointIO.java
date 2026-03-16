package frc.robot.subsystem.joint;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

public interface JointIO {    
    Angle getAngle();
    void spin(AngularVelocity speed);
    void moveTo(Angle setpoint);
    void stop();
}
