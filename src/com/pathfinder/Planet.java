package com.pathfinder;

import java.awt.Point;
import java.util.ArrayList;

public class Planet {
    private final Point upperRightLocation;
    private ArrayList<Robot> robots;
    private ArrayList<RobotScent> robotScents;
    Point maxUpperPoint = new Point(50,50);

    public Planet(Point upperRightLocation){
        if(upperRightLocation.x>maxUpperPoint.x
                || upperRightLocation.y > maxUpperPoint.y){
            throw new IllegalArgumentException("Point cannot exceed 50 in x or y");
        }
        this.upperRightLocation = upperRightLocation;
        robots = new ArrayList<>();
        robotScents = new ArrayList<>();
    }

    public ArrayList<Robot> getRobots(){
        return robots;
    }

    public void addANewRobot(Robot robot) {
        robots.add(robot);
    }

    public ArrayList<RobotScent> getRobotScents() {
        return robotScents;
    }

    public void addANewRobotScent(RobotScent robotScent) {
        robotScents.add(robotScent);
    }

    public Point getUpperRightLocation() {
        return upperRightLocation;
    }
}
