package com.test.services.services_rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Country name should be not empty")
    @Column(name = "name")
    private String name;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "country",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<City> cities;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public void addCityToCountry(City city) {
        if (cities == null) cities = new ArrayList<>();
        cities.add(city);
        city.setCountry(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String countryName) {
        this.name = countryName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + name + '\'' +
                '}';
    }
}
