package frc.robot.subsystem.joints;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;
import frc.robot.MotorConfiguration;

public class JointsIOSim implements JointsIO {
    Angle joints = Degrees.of(0);

    public JointsIOSim(MotorConfiguration config) {

    }
    
    @Override
    public Angle getAngle() {
        return joints;
    }

    @Override
    public void moveTo(Angle angle) {
        joints = angle;
    }
    
    @Override
    public void stop() {
        // yay
    }
}
