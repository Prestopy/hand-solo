package frc.lib;

import static edu.wpi.first.units.Units.Amps;

import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import frc.robot.MotorConfiguration;

public class TalonIO implements MotorIO {
    private LazyTalon motor;

    public TalonIO(MotorConfiguration config) {
        this.motor = new LazyTalonBuilder(
            config.MOTOR_ID(),
            config.CANBUS(),
            config.SENSOR_TO_MECHANISM_RATIO(), 
            config.INVERTED_VALUE(),
            config.STATOR_CURRENT_LIMIT().in(Amps),
            config.SUPPLY_CURRENT_LIMIT().in(Amps)
        )
            .withPIDFConfiguration(
                config.kP(),
                config.kI(),
                config.kP(),
                config.kS(),
                config.kG(),
                config.kV(),
                config.kA(),
                config.GRAVITY_TYPE(), 
                StaticFeedforwardSignValue.UseVelocitySign,
                0
            )
            .build();
    }

    @Override
    public void moveTo(Angle setpoint) {
        motor.setMMPositionTarget(setpoint, 0);
    }

    @Override
    public void spinAt(AngularVelocity speed) {
        motor.setMMVelocityTarget(speed, 0);
    }

    @Override
    public void stop() {
        motor.stop();
    }

    @Override
    public Angle getAngle() {
        return motor.getPosition();
    }
}
