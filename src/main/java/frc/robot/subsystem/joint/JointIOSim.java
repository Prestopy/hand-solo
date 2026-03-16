package frc.robot.subsystem.joint;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;
import frc.robot.MotorConfiguration;

public class JointIOSim implements JointIO {
    Angle joints = Degrees.of(0);

    public JointIOSim(MotorConfiguration config) {

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
