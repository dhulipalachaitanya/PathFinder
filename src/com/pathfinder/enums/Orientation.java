package com.pathfinder.enums;

public enum Orientation {
    N("North"),
    S("South"),
    E("East"),
    W("West");

    private final String direction;

    Orientation(String direction){
        this.direction = direction;
    }
    public String getDirection(){
        return direction;
    }
}
