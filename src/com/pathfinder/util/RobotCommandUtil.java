package com.pathfinder.util;

import com.pathfinder.enums.Orientation;
import com.pathfinder.Robot;
import com.pathfinder.RobotScent;

import java.awt.Point;

public class RobotCommandUtil {

    /**
     * Moves the robot forward in the direction of the robot orientation.
     * Sets scent in case the robot is lost
     * @param robot
     */
    public static void moveForward(Robot robot){
        RobotScent newScent = new RobotScent(robot.getPosition(),robot.getOrientation());
        if(!hasMatchingScent(newScent,robot)){
            Point position = robot.getPosition();
            switch(robot.getOrientation()){
                case E: position.x++;break;
                case N: position.y++;break;
                case W: position.x--;break;
                case S: position.y--;break;
            }
            robot.setPosition(position);
            if(isRobotLost(robot)){
//                if robot is lost, set the scent and set in planet as well as this is a final step
                robot.setRobotScent(newScent);
                robot.getPlanet().addANewRobotScent(newScent);
            }
        }
    }

    /**
     * executes a set of string instructions for the robot in case the robot is not Lost
     * @param robot
     * @param instructions
     */

    public static void executeInstructions(Robot robot, String instructions){
        for (int i = 0; i < instructions.length(); i++) {
//            don't need to execute in case robot is lost
            if(robot.isLost()){
                break;
            }
            switch (instructions.charAt(i)){
                case 'R': turnRight(robot); break;
                case 'L': turnLeft(robot);break;
                case 'F': moveForward(robot);break;
                default: throw new IllegalArgumentException("Instruction not identified");
            }
        }
    }

    /**
     * turns the robot left to it's relative position
     * @param robot
     */

    private static void turnLeft(Robot robot) {
        Orientation orientation = robot.getOrientation();
        switch(orientation){
            case N: orientation = Orientation.W;break;
            case E: orientation = Orientation.N;break;
            case W: orientation = Orientation.S;break;
            case S: orientation = Orientation.E;break;
        }
        robot.setOrientation(orientation);
    }

    /**
     * turns the robot right to the relative position
     * @param robot
     */

    private static void turnRight(Robot robot) {
        Orientation orientation = robot.getOrientation();
        switch(orientation){
            case N: orientation = Orientation.E;break;
            case E: orientation = Orientation.S;break;
            case W: orientation = Orientation.N;break;
            case S: orientation = Orientation.W;break;
        }
        robot.setOrientation(orientation);
    }


    /**
     * checks and returns true if a robot is beyond the planet boundary else false
     * @param robot
     * @return boolean
     */
    private static boolean isRobotLost(Robot robot){
        Point position = robot.getPosition();
        return (position.x < 0 || position.y < 0
                || position.x > robot.getPlanet().getUpperRightLocation().x
                || position.y > robot.getPlanet().getUpperRightLocation().y);
    }

    /**
     * Checks and returns if the planet has a matching scent from a previous robot
     * @param robotScent
     * @param robot
     * @return boolean
     */
    private static boolean hasMatchingScent(RobotScent robotScent,Robot robot){
        return robot.getPlanet().getRobotScents()
                .stream().anyMatch(existingScent -> existingScent.equals(robotScent));
    }

}
