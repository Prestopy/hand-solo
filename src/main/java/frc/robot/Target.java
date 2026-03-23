package frc.robot;

import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.Radians;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Distance;
import frc.robot.subsystem.joint.ArmConstants;
import frc.robot.subsystem.base.BaseConstants;

public class Target {
    private Translation3d target = null;

    public Target() {}

    /**
     * Where (0, 0, 0) is the base, and (0, 0, h) is the first joint.
     * @param position
     * @return
     */
    public Target withPosition(Translation3d position) {
        target = position;
        return this;
    }

    /**
     * Calculates the angles needed to reach the target position.
     * @return an array of angles in the order of base rotation, proximal angle, and distal angle.
     */
    public Angle[] calculateConfiguration() {
        /**
         * The distance from the base to the target, ignoring height.
         * This is the hypotenuse of the triangle formed by the x and y coordinates of the target.
         */
        Distance baseToTargetDist = Meters.of(Math.sqrt(target.getX()*target.getX() + target.getY()*target.getY()));

        /**
         * The angle of the base rotation, which is the angle between the x-axis and the projection of the target onto the x-y plane.
         */
        Angle baseRotation = Radians.of(Math.atan2(target.getY(), target.getX()));

        /**
         * The plane perpendicular to the base that contains the target and the base joint
         */
        Translation2d slicedTarget = new Translation2d(baseToTargetDist.in(Meters), target.getY()); // ignoring base rotation

        /**
         * The position of the target relative to the base joint, in the plane of the arm.
         * B - A = A points to B
         */
        Translation2d relTarget = slicedTarget.minus(new Translation2d(0, BaseConstants.BASE_HEIGHT.in(Meters))); // move relative to base

        /**
         * The angle between the base plane and the vector pointing from the base joint to the target
         */
        Angle targetHeading = Radians.of(Math.atan2(relTarget.getY(), relTarget.getX()));

        /**
         * The distance from the base joint to the target, in the plane of the arm.
         */
        Distance LD = Meters.of(Math.sqrt(relTarget.getX()*relTarget.getX() + relTarget.getY()*relTarget.getY()));

        Distance L1 = ArmConstants.PROXIMAL_LENGTH;
        Distance L2 = ArmConstants.DISTAL_LENGTH;
        

        /**
         * PROXIMAL ANGLE CALCULATION
         */

        /** 
         * The angle between the target vector and the proximal arm, calculated using the law of cosines.
        */
        Angle A1 = Radians.of(Math.acos(
            constrain(
                (sqrt(L1) + sqrt(LD) - sqrt(L2)) /
                (sqrt(L1)*sqrt(LD)*2)
            , -1.0, 1.0)
        ));

        /**
         * The angle between the base plane and the proximal arm, before flipping
         */
        Angle A1before = targetHeading.plus(A1);
        boolean flip = false;

        // If the angle is goes past the base plane, flip the angle
        if (A1before.in(Radians) < 0 || A1before.in(Radians) > Math.PI) flip = true; // TODO: Make sure to calculate the angle- it can go below 0 deg because of the offset

        if (flip) A1 = targetHeading.minus(A1);
        else A1 = targetHeading.plus(A1);



        /**
         * DISTAL ANGLE CALCULATION
         */

        /**
         * The angle between the proximal arm and the distal arm, calculated using the law of cosines.
        */
        Angle A2 = Radians.of(Math.acos(
            constrain(
                (sqrt(L1) + sqrt(L2) - sqrt(LD)) /
                (sqrt(L1)*sqrt(L2)*2)
            , -1.0, 1.0)
        ));

        if (flip) A2 = Radians.of(Math.PI).plus(A2);
        else A2 = Radians.of(Math.PI).plus(A2).times(-1);

        return new Angle[]{baseRotation, A1, A2};
    }

    private double constrain(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    /**
     * Return the square root of a distance, in meters.
     * @param d
     * @return
     */
    private double sqrt(Distance d) {
        return Math.sqrt(d.in(Meters));
    }

    public Translation3d getPosition() {
        return target;
    }
}
