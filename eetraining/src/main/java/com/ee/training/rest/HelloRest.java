package com.ee.training.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/first")
public class HelloRest {

    @Path("/hello")
    @GET
    public String hello1() {
        return "Hello world";
    }

    @Path("/hello")
    @POST
    public String helloPost() {
        return "Hello world Post";
    }

    @Path("/hello")
    @DELETE
    public String helloDelete() {
        return "Hello world Delete";
    }

    @Path("/greet")
    @GET
    public String greet1() {
        return "Greetings 1 !!";
    }

    @Path("/greet")
    @PUT
    public String greet2() {
        return "Greetings 2 !!";
    }

}
