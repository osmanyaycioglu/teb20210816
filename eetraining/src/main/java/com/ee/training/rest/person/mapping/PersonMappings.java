package com.ee.training.rest.person.mapping;

import java.util.List;
import java.util.stream.Collectors;

import com.ee.training.rest.Person;
import com.ee.training.rest.person.model.PersonDTO;

public class PersonMappings {

    public static PersonDTO toDTO(final Person person) {
        if (person == null) {
            return null;
        }
        PersonDTO personDTOLoc = new PersonDTO();
        personDTOLoc.setName(person.getName());
        personDTOLoc.setSurname(person.getSurname());
        personDTOLoc.setHeight(person.getHeight());
        personDTOLoc.setWeight(person.getWeight());
        personDTOLoc.setUsername(person.getUsername());
        personDTOLoc.setAddress(person.getAddress());
        personDTOLoc.setPhones(person.getPhones());
        return personDTOLoc;
    }

    public static Person fromDTO(final PersonDTO person) {
        if (person == null) {
            return null;
        }
        Person personModel = new Person();
        personModel.setName(person.getName());
        personModel.setSurname(person.getSurname());
        personModel.setHeight(person.getHeight());
        personModel.setWeight(person.getWeight());
        personModel.setUsername(person.getUsername());
        personModel.setAddress(person.getAddress());
        personModel.setPhones(person.getPhones());
        return personModel;
    }

    public static List<Person> personToDtoList(final List<PersonDTO> personDTO) {
        List<Person> collectLoc = personDTO.stream()
                                           .map(p -> PersonMappings.fromDTO(p))
                                           .collect(Collectors.toList());
        return collectLoc;
    }

}
