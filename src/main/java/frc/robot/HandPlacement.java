package frc.robot;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public class HandPlacement {
    public final Angle baseRotation;
    public final Angle proximalAngle;
    public final Angle distalAngle;
    
    public HandPlacement(Angle baseRotation, Angle proximalAngle, Angle distalAngle) {
        this.baseRotation = baseRotation;
        this.proximalAngle = proximalAngle;
        this.distalAngle = distalAngle;
    }

    public static HandPlacement of(Angle baseRotation, Angle proximalAngle, Angle distalAngle) {
        return new HandPlacement(baseRotation, proximalAngle, distalAngle);
    }

    public static HandPlacement zero() {
        return new HandPlacement(
            Degrees.of(0.0),
            Degrees.of(0.0),
            Degrees.of(0.0)
        );
    }
}
