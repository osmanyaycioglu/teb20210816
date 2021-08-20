package com.ee.training.cdi;

import java.io.Serializable;

import javax.inject.Named;

@Named("ESP")
public class SayHelloESP implements ISayHello, Serializable {


    @Override
    public String hello(final String name) {
        return "Ola " + name;
    }

}
