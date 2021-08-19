package com.ee.training.rest.person.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.ee.training.rest.person.model.PersonDTO;

@Singleton
@LocalBean
public class PersonStorage {

    private final Map<String, PersonDTO> personMap = new ConcurrentHashMap<>();

    public void add(final PersonDTO person) {
        PersonDTO personLoc = this.personMap.get(person.getUsername());
        if (personLoc != null) {
            throw new IllegalArgumentException("Bu person memory de var");
        }
        this.personMap.put(person.getUsername(),
                           person);
    }

    public void update(final PersonDTO person) {
        PersonDTO personLoc = this.personMap.get(person.getUsername());
        if (personLoc == null) {
            throw new IllegalArgumentException("Bu person memory de yok");
        }
        this.personMap.put(person.getUsername(),
                           person);
    }

    public void remove(final String usernameParam) {
        this.personMap.remove(usernameParam);
    }

    public PersonDTO getOne(final String usernameParam) {
        return this.personMap.get(usernameParam);
    }

    public List<PersonDTO> getAll() {
        return new ArrayList<>(this.personMap.values());
    }

    public List<PersonDTO> getByName(final String nameParam) {
        List<PersonDTO> listLoc = new ArrayList<>();
        Collection<PersonDTO> valuesLoc = this.personMap.values();
        for (PersonDTO personDTOLoc : valuesLoc) {
            if (personDTOLoc.getName()
                            .equals(nameParam)) {
                listLoc.add(personDTOLoc);
            }
        }
        return listLoc;
    }

    public List<PersonDTO> getByName2(final String nameParam) {
        List<PersonDTO> collectLoc = this.personMap.values()
                                                   .stream()
                                                   .filter(p -> p.getName()
                                                                 .equals(nameParam))
                                                   .collect(Collectors.toList());
        return collectLoc;
    }


}
