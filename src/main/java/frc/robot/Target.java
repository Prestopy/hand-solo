package frc.robot;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Distance;
import frc.robot.subsystem.joint.ArmConstants;

public class Target {
    private Translation3d target = null;

    public Target() {}
    public Target withPosition(Translation3d position) {
        target = position;
        return this;
    }

    /**
     * Calculates the angles needed to reach the target position.
     * @return an array of angles in the order of base rotation, proximal angle, and distal angle.
     */
    public Angle[] calculateConfiguration() {
        Distance dist = Meters.of(Math.sqrt(target.getX()*target.getX() + target.getY()*target.getY()));

        Angle baseRotation = Radians.of(Math.atan2(target.getY(), target.getX()));
        Translation2d slicedTarget = new Translation2d(dist.in(Meters), target.getY()); // ignoring base rotation
        Translation2d relTarget = slicedTarget.minus(new Translation2d(0, 0)); // move relative to base

        Angle targetHeading = Radians.of(Math.atan2(relTarget.getY(), relTarget.getX()));
        Angle invertedTargetHeading = targetHeading.times(-1);

        Angle PI = Radians.of(Math.PI);

        double LD = Meters.of(Math.sqrt(relTarget.getX()*relTarget.getX() + relTarget.getY()*relTarget.getY())).in(Meters);
        double L1 = ArmConstants.PROXIMAL_LENGTH.in(Meters);
        double L2 = ArmConstants.DISTAL_LENGTH.in(Meters);

        
        // Proximal angle #######
        Angle A1 = Radians.of(Math.acos(
            constrain(
                (sqrt(L2)*-1 + sqrt(L1) + sqrt(LD)) /
                (sqrt(L1)*sqrt(LD)*2)
            , -1.0, 1.0)
        ));
        Angle fA1 = A1.copy();


        // where the arm would point before flipping
        Angle A1before = invertedTargetHeading.plus(A1); // why multiply by -1??
        boolean flip = false;
        if (A1before.in(Radians) < 0 || A1before.in(Radians) > Math.PI) flip = true; // TODO: Make sure to calculate the angle- it can go below 0 deg because of the offset

        if (flip) fA1 = invertedTargetHeading.minus(A1); // why multiply by -1??
        else fA1 = invertedTargetHeading.plus(A1); // why multiply by -1??


        // Distal angle #######
        Angle A2 = Radians.of(Math.acos(
            constrain(
                (sqrt(L1) + sqrt(L2) - sqrt(LD)) /
                (sqrt(L1)*sqrt(L2)*2)
            , -1.0, 1.0)
        ));
        Angle fA2 = A2.copy();

        if (flip) fA2 = PI.plus(A2);
        else fA2 = PI.plus(A2).times(-1);

        return new Angle[]{baseRotation, fA1, fA2};
    }

    private double constrain(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    private double sqrt(double d) {
        return Math.sqrt(d);
    }

    public Translation3d getPosition() {
        return target;
    }
}
