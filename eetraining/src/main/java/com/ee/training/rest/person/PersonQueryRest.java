package com.ee.training.rest.person;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ee.training.rest.Person;

@Path("/api2/v1/person/query")
public class PersonQueryRest {

    @Path("/get/one")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@QueryParam("username") final String username) {
        return null;
    }

    @Path("/get/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return null;
    }

    @Path("/get/byname")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonByName(@QueryParam("name") final String name) {
        return null;
    }

}
