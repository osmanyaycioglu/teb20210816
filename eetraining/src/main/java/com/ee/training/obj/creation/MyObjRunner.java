package com.ee.training.obj.creation;

import com.ee.training.rest.HelloRest;

public class MyObjRunner {

    public static void main(final String[] args) {
        MyObj1 myObj1Loc = new MyObj1();
        MyObj2 obj2Loc = new MyObj2();
        obj2Loc.setMyObj1(myObj1Loc);
        obj2Loc.sayHello();

        HelloRest helloRestLoc = new HelloRest();
    }
}
