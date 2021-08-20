package com.ee.training.cdi;

import java.io.Serializable;

import javax.inject.Named;

@Named("TR")
public class SayHelloTR implements ISayHello, Serializable {

    @Override
    public String hello(final String name) {
        return "Merhaba " + name;
    }

}
