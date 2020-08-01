package com.pathfinder;

import com.pathfinder.enums.Orientation;

import java.awt.Point;

public class RobotScent {
    private final Point point;
    private final Orientation orientation;

    public RobotScent(Point point, Orientation orientation) {
        this.point = point;
        this.orientation = orientation;
    }

    public Point getPoint() {
        return point;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object robotScent){
        if(robotScent == this) return true;
        if(!(robotScent instanceof RobotScent)) return false;

        RobotScent scent = (RobotScent)robotScent;

        return point.equals(scent.getPoint())
                && orientation.getDirection().equals(scent.orientation.getDirection());
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + point.hashCode();
        result = 31 * result + orientation.hashCode();
        return result;
    }
}
