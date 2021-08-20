package com.ee.training.cdi;

import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class SayHelloFactory {

    @Produces
    @Named("DYN")
    @SessionScoped
    public ISayHello createSayHello() {
        Random randomLoc = new Random();
        int nextIntLoc = randomLoc.nextInt(3);
        switch (nextIntLoc) {
            case 0:
                return new SayHello();
            case 1:
                return new SayHelloTR();
            case 2:
                return new SayHelloESP();
            default:
                return new SayHello();
        }
    }

}
