package frc.robot.subsystem.joints;

import edu.wpi.first.units.measure.Angle;
import frc.lib.LazyTalon;
import frc.robot.MotorConfiguration;

public class JointsIOReal implements JointsIO {
    private LazyTalon motor;

    public JointsIOReal(MotorConfiguration config) {
        motor = new LazyTalon(config.MOTOR_ID(), config.INVERTED_VALUE());
    }

    @Override
    public void moveTo(Angle setpoint) {
        motor.moveTo(setpoint);
    }

    @Override
    public void stop() {
        motor.stop();
    }

    @Override
    public Angle getAngle() {
        return motor.getFeedbackPosition();
    }
}
