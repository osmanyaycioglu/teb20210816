package com.ee.training.rest.person.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ee.training.rest.Person;
import com.ee.training.rest.person.mapping.PersonMappings;
import com.ee.training.rest.person.model.PersonDTO;
import com.ee.training.rest.person.service.PersonProvision;

@WebService(targetNamespace = "http://training.teb.com")
public class PersonProvisonWS {

    @EJB
    private PersonProvision pp;

    public String add(@WebParam(name = "person") final Person person) {
        this.pp.add(PersonMappings.toDTO(person));
        return "SUCCESS";
    }

    public String update(@WebParam(name = "person") final Person person) {
        this.pp.update(PersonMappings.toDTO(person));
        return "SUCCESS";
    }

    public String remove(@WebParam(name = "personid") final Long personId) {
        this.pp.remove(personId);
        return "SUCCESS";
    }

    public Person getPerson(@WebParam(name = "personid") final Long personId) {
        return PersonMappings.fromDTO(this.pp.getOne(personId));
    }

    public List<Person> getAll() {
        List<PersonDTO> personDTOListLoc = this.pp.getAll();
        return PersonMappings.personToDtoList(personDTOListLoc);
    }

    @WebMethod(exclude = true)
    public List<Person> getPersonByName(@WebParam(name = "name") final String name) {
        List<PersonDTO> personDTOListLoc = this.pp.getByName(name);
        return PersonMappings.personToDtoList(personDTOListLoc);
    }
}
