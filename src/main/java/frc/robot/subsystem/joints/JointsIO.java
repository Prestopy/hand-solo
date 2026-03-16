package frc.robot.subsystem.joints;

import edu.wpi.first.units.measure.Angle;

public interface JointsIO {    
    Angle getAngle();
    void moveTo(Angle setpoint);
    void stop();
}
