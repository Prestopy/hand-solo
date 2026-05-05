package frc.robot.subsystem.joint;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import frc.lib.TalonIO;
import frc.robot.MotorConfiguration;

public class JointIOSim extends TalonIO {
    Angle joints = Degrees.of(0);

    public JointIOSim(MotorConfiguration config) {
        super(config);
    }
    
    @Override
    public Angle getAngle() {
        return joints;
    }

    @Override
    public void spinAt(AngularVelocity speed) {
        // asdf
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
