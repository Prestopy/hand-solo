package frc.robot.subsystem.claw;

import frc.lib.MotorSubsystem;
import frc.lib.TalonIO;

public class Claw extends MotorSubsystem<TalonIO> {
    public Claw(TalonIO io) {
        super(io);
    }
}