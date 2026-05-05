package frc.robot.subsystem.base;

import frc.lib.MotorSubsystem;
import frc.lib.TalonIO;

public class Base extends MotorSubsystem<TalonIO> {
    public Base(TalonIO io) {
        super(io);
    }
}
