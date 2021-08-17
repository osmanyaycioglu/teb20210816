package com.training.java;

import java.io.Serializable;

public abstract class Arac implements IArac, Serializable, Comparable<Arac> {

    protected int speed;


    public int getSpeed() {
        return this.speed;
    }

    // abstract void back();


    public void setSpeed(final int speedParam) {
        this.speed = speedParam;
    }

    @Override
    public int compareTo(final Arac oParam) {
        return 0;
    }
}
