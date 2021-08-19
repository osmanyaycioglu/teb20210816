package com.ee.training.rest.person;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ee.training.rest.Person;

@Path("/api2/v1/person/provision")
public class PersonProvisonRest {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(final Person person) {
        return "SUCCESS";
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(final Person person) {
        return "SUCCESS";
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String remove(@QueryParam("username") final String username) {
        return "SUCCESS";
    }

}
