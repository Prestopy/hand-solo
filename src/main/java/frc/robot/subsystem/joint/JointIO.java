package frc.robot.subsystem.joint;

import edu.wpi.first.units.measure.Angle;

public interface JointIO {    
    Angle getAngle();
    void moveTo(Angle setpoint);
    void stop();
}
