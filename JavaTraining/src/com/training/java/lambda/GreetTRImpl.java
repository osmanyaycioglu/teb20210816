package com.training.java.lambda;


public class GreetTRImpl implements IGreet {

    @Override
    public String greet(final String nameParam) {
        return "merhaba " + nameParam;
    }

}
