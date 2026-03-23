package frc.robot.subsystem.base;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.DegreesPerSecond;
import static edu.wpi.first.units.Units.Meters;
import static frc.robot.RobotContainer.CANBUS;

import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Distance;
import frc.robot.MotorConfiguration;

public class BaseConstants {
    public static final AngularVelocity MAX_SPEED = DegreesPerSecond.of(45); // 90 degrees per second
    public static final Distance BASE_HEIGHT = Meters.of(0.2); // 20 cm

    public class Configurations {
        public static final MotorConfiguration BASE = new MotorConfiguration(
            16,
            CANBUS,

            Amps.of(30), // Stator limit
            Amps.of(30), // Supply limit

            1.0,

            InvertedValue.CounterClockwise_Positive, // Inverted value
            1.0,
            
            0, // S
            0, // G
            0, // V
            0, // A
            1, // P
            0, // I
            0, // D

            0.12,
            0.01,

            GravityTypeValue.Elevator_Static, // Gravity type
            
            10,
            20
        );
    }
}
