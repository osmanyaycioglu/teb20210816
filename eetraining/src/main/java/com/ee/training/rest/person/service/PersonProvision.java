package com.ee.training.rest.person.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.ee.training.rest.person.data.PersonDao;
import com.ee.training.rest.person.model.PersonDTO;

@Singleton
@LocalBean
public class PersonProvision {

    @EJB
    private PersonDao ps;

    public void add(final PersonDTO personDTOParam) {
        this.ps.add(personDTOParam);
    }

    public void update(final PersonDTO dtoParam) {
        this.ps.update(dtoParam);

    }

    public void remove(final Long personId) {
        this.ps.remove(personId);
    }

    public PersonDTO getOne(final Long personId) {
        return this.ps.getOne(personId);
    }

    public List<PersonDTO> getAll() {
        return this.ps.getAll();
    }

    public List<PersonDTO> getByName(final String nameParam) {
        return this.ps.getByName(nameParam);
    }

}
