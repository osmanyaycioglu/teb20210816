package com.training.java.lambda;


public class GreetImpl implements IGreet {

    @Override
    public String greet(final String nameParam) {
        return "hello " + nameParam;
    }

}
