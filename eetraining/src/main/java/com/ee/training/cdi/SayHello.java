package com.ee.training.cdi;

import java.io.Serializable;

import javax.inject.Named;

@Named("ENG")
public class SayHello implements ISayHello, Serializable {

    @Override
    public String hello(final String name) {
        return "Hello " + name;
    }

}
