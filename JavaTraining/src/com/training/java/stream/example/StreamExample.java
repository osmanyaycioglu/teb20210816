package com.training.java.stream.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(final String[] args) throws Exception {
        Map<String, Person> collectLoc = Files.readAllLines(Paths.get("persons.txt"))
                                              .stream()
                                              .map(StreamExample::StringToPerson)
                                              .collect(Collectors.toMap(d -> d.getUsername(),
                                                                        d -> d));
        System.out.println(collectLoc);
        //        Map<String, Person> collectLoc2 = Files.readAllLines(Paths.get("persons.txt"))
        //                                               .stream()
        //                                               .map(s -> {
        //                                                   String[] splitLoc = s.split(",");
        //                                                   Person personLoc = new Person();
        //                                                   personLoc.setName(splitLoc[0]);
        //                                                   personLoc.setSurname(splitLoc[1]);
        //                                                   personLoc.setUsername(splitLoc[2]);
        //                                                   return personLoc;
        //
        //                                               })
        //                                               .collect(Collectors.toMap(d -> d.getUsername(),
        //                                                                         d -> d));
    }

    public static Person StringToPerson(final String line) {
        String[] splitLoc = line.split(",");
        Person personLoc = new Person();
        personLoc.setName(splitLoc[0]);
        personLoc.setSurname(splitLoc[1]);
        personLoc.setUsername(splitLoc[2]);
        return personLoc;
    }
}
