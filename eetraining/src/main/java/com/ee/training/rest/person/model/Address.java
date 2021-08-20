package com.ee.training.rest.person.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long   addId;
    private String city;
    private String street;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }

    public Long getAddId() {
        return this.addId;
    }

    public void setAddId(final Long addIdParam) {
        this.addId = addIdParam;
    }


}
