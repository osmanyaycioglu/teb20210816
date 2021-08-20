package com.ee.training.rest.person.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NamedQueries({
                @NamedQuery(name = "select_all", query = "select p from PersonDTO p"),
                @NamedQuery(name = "select_by_name", query = "select p from PersonDTO p where p.name=?1"),
})

@Entity
@Table(name = "person")
public class PersonDTO {

    @Id
    @GeneratedValue
    private Long        perId;
    @Column(name = "name", length = 50, nullable = false)
    @NotEmpty
    @Size(min = 2, max = 50)
    private String      name;
    private String      surname;
    @Max(300)
    @Min(20)
    private Integer     weight;
    private Integer     height;
    private String      username;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address     address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Long getPerId() {
        return this.perId;
    }

    public void setPerId(final Long perIdParam) {
        this.perId = perIdParam;
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
