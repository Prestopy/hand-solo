package frc.robot.subsystem.arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystem.arm.ArmIO.ArmIOInputs;

public class Arm extends SubsystemBase {

    private ArmIO io;
    private ArmIOInputs inputs;

    public Arm(ArmIO io) {
        this.io = io;
        this.inputs = new ArmIOInputs();
    }
}
