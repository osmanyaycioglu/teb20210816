package com.training.java;


public interface IArac {

    public static final int a = 10;

    void forward();

    void back();

    void turnLeft();

    void turnRight();

    // New feature 1.8
    default String move() {
        this.forward();
        this.back();
        return "Moving";
    }

    // New feature 1.8
    public static void newFeatureStaticClass() {
        System.out.println("1.8 new feature");
    }

}
