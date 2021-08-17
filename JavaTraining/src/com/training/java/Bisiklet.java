package com.training.java;


public class Bisiklet extends Arac {

    @Override
    public void forward() {
        System.out.println("Bisiklet ileri gidiyor");
    }

    @Override
    public void back() {
        System.out.println("Bisiklet geri gitmez");

    }

    @Override
    public void turnLeft() {
        System.out.println("Bisiklet sola döndü");

    }

    @Override
    public void turnRight() {
        System.out.println("Bisiklet sağa döndü");

    }

}
