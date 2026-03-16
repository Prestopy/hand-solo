package frc.robot;

import edu.wpi.first.math.geometry.Translation3d;

public class Target {
    private Translation3d target = null;

    public Target() {}
    public Target withPosition(Translation3d position) {
        target = position;
        return this;
    }

    public void moveToPosition() {

    }

    public Translation3d getPosition() {
        return target;
    }
}
