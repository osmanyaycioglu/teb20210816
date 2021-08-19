package com.ee.training.rest.person.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.ee.training.rest.person.data.PersonStorage;
import com.ee.training.rest.person.model.PersonDTO;

@Singleton
@LocalBean
public class PersonProvision {

    @EJB
    private PersonStorage ps;

    public void add(final PersonDTO personDTOParam) {
        this.ps.add(personDTOParam);
    }

    public void update(final PersonDTO dtoParam) {
        this.ps.update(dtoParam);

    }

    public void remove(final String usernameParam) {
        this.ps.remove(usernameParam);
    }

    public PersonDTO getOne(final String usernameParam) {
        return this.ps.getOne(usernameParam);
    }

    public List<PersonDTO> getAll() {
        return this.ps.getAll();
    }

    public List<PersonDTO> getByName(final String nameParam) {
        return this.ps.getByName(nameParam);
    }

}
