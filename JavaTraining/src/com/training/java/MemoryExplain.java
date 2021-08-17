package com.training.java;


public class MemoryExplain {

    public static void main(final String[] args) {
        String strLoc = "osman";
        int primInt = 10;
        Integer intVal = 10;
        Integer intVal2 = new Integer(10);
        intVal2 = null; // refcount 0

        Car carLoc = new Car(100,
                             100,
                             "BMW");//      Stack ref carLoc  --- Heap 32 byte refcount 1
        Car carLoc2 = carLoc; //     refcount 2
        carLoc.setHorsePower(100);
        carLoc.setSpeed(10);
        carLoc.forward();

        Arac aracLoc = new Car(100,
                               100,
                               "BMW");

        //        IArac arac = new Car(100,
        //                             100,
        //                             "BMW");
        IArac arac = new Bisiklet();

        arac.forward();
        arac.back();
        arac.forward();
        arac.turnLeft();
        arac.forward();
        arac.turnRight();
        arac.forward();
    }

}
