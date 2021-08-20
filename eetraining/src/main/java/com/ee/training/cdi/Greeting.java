package com.ee.training.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ee.training.cdi.interceptor.Inter;

@RequestScoped
public class Greeting {

    @Inject
    @Named("DYN")
    private ISayHello hello;

    @Inject
    @Named("ESP")
    private ISayHello hello2;

    @Inter
    public String greet(final String name) {
        String helloLoc = this.hello.hello(name);
        System.out.println(helloLoc);
        System.out.println(this.hello2.hello(name));
        return helloLoc;
    }

}
