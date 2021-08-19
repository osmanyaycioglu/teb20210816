package com.ee.training.rest.person.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ee.training.rest.Person;
import com.ee.training.rest.person.mapping.PersonMappings;
import com.ee.training.rest.person.model.PersonDTO;
import com.ee.training.rest.person.service.PersonProvision;

@Path("/api/v1/person/provision")
public class PersonProvisonRest2 {

    @EJB
    private PersonProvision pp;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(final Person person) {
        this.pp.add(PersonMappings.toDTO(person));
        return "SUCCESS";
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(final Person person) {
        this.pp.update(PersonMappings.toDTO(person));
        return "SUCCESS";
    }

    @Path("/remove")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String remove(@QueryParam("pid") final Long personId) {
        this.pp.remove(personId);
        return "SUCCESS";
    }

    @Path("/get/one")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@QueryParam("pid") final Long personId) {
        return PersonMappings.fromDTO(this.pp.getOne(personId));
    }

    @Path("/get/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        List<PersonDTO> personDTOListLoc = this.pp.getAll();
        return PersonMappings.personToDtoList(personDTOListLoc);
    }


    @Path("/get/byname")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonByName(@QueryParam("name") final String name) {
        List<PersonDTO> personDTOListLoc = this.pp.getByName(name);
        return PersonMappings.personToDtoList(personDTOListLoc);
    }
}
