package frc.robot;

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
}
