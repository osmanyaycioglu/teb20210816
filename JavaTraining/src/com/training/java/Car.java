package com.training.java;

public class Car extends Arac {

    private int     doorCount;
    private Integer horsePower;
    private String  model;


    public Car(final int horsePowerParam,
               final int speed,
               final String modelParam) {
        super();
        this.horsePower = horsePowerParam;
        this.model = modelParam;
        this.speed = speed;
    }

    @Override
    public void forward() {
        int forward = this.horsePower * 2 * this.getSpeed();
        System.out.println("Car moved forward : " + forward);
    }

    @Override
    public void back() {
        System.out.println("back");
    }

    public int getDoorCount() {
        return this.doorCount;
    }

    public void setDoorCount(final int doorCountParam) {
        this.doorCount = doorCountParam;
    }

    public Integer getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(final Integer horsePowerParam) {
        this.horsePower = horsePowerParam;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(final String modelParam) {
        this.model = modelParam;
    }

    public void doSomething() {
        System.out.println("Doing something");
    }

    @Override
    public void turnLeft() {
        System.out.println("turning left");

    }

    @Override
    public void turnRight() {
        System.out.println("turning right");

    }


}
