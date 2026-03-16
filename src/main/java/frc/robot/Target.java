package frc.robot;

import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Distance;

public class Target {
    private Translation3d target = null;

    public Target() {}
    public Target withPosition(Translation3d position) {
        target = position;
        return this;
    }

    public void moveToPosition() {
        Distance dist = Meters.of(Math.sqrt(target.getX()*target.getX() + target.getY()*target.getY()));

        Angle baseRotation = Radians.of(Math.atan2(target.getY(), target.getX()));
        Translation2d slicedTarget = new Translation2d(dist.in(Meters), target.getY()); // ignoring base rotation
    }

    public Translation3d getPosition() {
        return target;
    }
}
