package frc.robot;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;

import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.LinearVelocity;

public class RobotConstants {
    public static final LinearVelocity maxSpeed = MetersPerSecond.of(1.0); // m/s
    public static final LinearAcceleration slewRate = MetersPerSecondPerSecond.of(3.0); // m/s^2
}
