package com.ee.training.obj.creation;


public class MyObj2 {

    private MyObj1 myObj1;

    public MyObj2() {
    }

    public MyObj2(final MyObj1 myObj1Param) {
        super();
        this.myObj1 = myObj1Param;
    }

    public void sayHello() {
        String helloLoc = this.myObj1.hello();
        System.out.println(helloLoc);
    }

    public MyObj1 getMyObj1() {
        return this.myObj1;
    }

    public void setMyObj1(final MyObj1 myObj1Param) {
        this.myObj1 = myObj1Param;
    }
}
