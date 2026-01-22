package frc.robot.subsystem.arm;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;

public class ArmIOReal implements ArmIO {
    private TalonFX baseMotor;
    private TalonFX proximalMotor;
    private TalonFX distalMotor;
    private TalonFX wristMotor;

    @Override
    public void setBaseAngle(Angle angle) {
        // Implement hardware control to set the base angle of the arm
    }

    @Override
    public void setProximalAngle(Angle angle) {
        // Implement hardware control to set the proximal angle of the arm
    }

    @Override
    public void setDistalAngle(Angle angle) {
        // Implement hardware control to set the distal angle of the arm
    }

    @Override
    public void setWristAngle(Angle angle) {
        // Implement hardware control to set the wrist angle of the arm
    }
}
