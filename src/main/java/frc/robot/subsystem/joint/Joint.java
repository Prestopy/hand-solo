package frc.robot.subsystem.joint;

import frc.lib.MotorSubsystem;
import frc.lib.TalonIO;

public class Joint extends MotorSubsystem<TalonIO> {
    public Joint(TalonIO io) {
        super(io);
    }
}
