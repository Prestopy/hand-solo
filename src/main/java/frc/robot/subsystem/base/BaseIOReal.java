package frc.robot.subsystem.base;

import frc.lib.TalonIO;
import frc.robot.MotorConfiguration;

public class BaseIOReal extends TalonIO {
    public BaseIOReal(MotorConfiguration config) {
        super(config);
    }
}