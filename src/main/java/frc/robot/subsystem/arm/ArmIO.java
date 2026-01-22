package frc.robot.subsystem.arm;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public interface ArmIO {
    class ArmIOInputs {
        public Angle baseAngle = Degrees.of(0.0);
        public Angle proximalAngle = Degrees.of(0.0);
        public Angle distalAngle = Degrees.of(0.0);
        public Angle wristAngle = Degrees.of(0.0);
    }

    void setBaseAngle(Angle angle);
    void setProximalAngle(Angle angle);
    void setDistalAngle(Angle angle);
    void setWristAngle(Angle angle);
}
