package com.ee.training.rest;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.ee.training.rest.person.model.Address;
import com.ee.training.rest.person.model.Phone;

@XmlRootElement
public class Person {

    @NotEmpty(message = "isim boş olamaz")
    @Size(min = 2, max = 20, message = "isim 2 ile 20 arasında olmalı")
    @PathParam("is")
    private String      name;
    @NotEmpty(message = "soyisim boş olamaz")
    @Size(min = 2, max = 30, message = "soyisim 2 ile 30 arasında olmalı")
    @QueryParam("so")
    private String      surname;
    @QueryParam("ag")
    @NotNull
    @Max(value = 300, message = "ağırlık 300 den küçük olmalı")
    @Min(20)
    private Integer     weight;
    @NotNull
    @HeaderParam("uz")
    @Max(300)
    @Min(50)
    private Integer     height;

    @NotEmpty
    @Size(min = 5, max = 12, message = "username 5 ile 12 arasında olmalı")
    private String      username;

    private Address     address;

    private List<Phone> phones;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final List<Phone> phonesParam) {
        this.phones = phonesParam;
    }


}
