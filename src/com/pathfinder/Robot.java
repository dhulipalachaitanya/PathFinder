package com.pathfinder;

import com.pathfinder.enums.Orientation;
import com.pathfinder.util.RobotCommandUtil;

import java.awt.*;

public class Robot {
    private Point position;
    private Orientation orientation;
    private RobotScent robotScent;
    private final Planet planet;
    private boolean isLost;

    public Robot(Point position, Orientation orientation,
                 Planet planet) {
        this.position = position;
        this.orientation = orientation;
        this.planet = planet;
        planet.addANewRobot(this);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setRobotScent(RobotScent robotScent) {
        this.robotScent = robotScent;
    }

    public Planet getPlanet() {
        return planet;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    /**
     * custom format for the scent of the robot
     * @return robotScent
     */
    public String toString(){
        if(isLost()){
            return robotScent.getPoint().x + " " + robotScent.getPoint().y + " " + robotScent.getOrientation().toString() + " LOST";
        } else return position.x + " " + position.y + " " + orientation.toString();
    }
}
