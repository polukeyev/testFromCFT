package com.test.services.services_rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "City name should be not empty")
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                        CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "city",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ServicePoint> servicePoints;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public void addServiceToCity(ServicePoint servicePoint) {
        if (servicePoints == null) servicePoints = new ArrayList<>();
        servicePoints.add(servicePoint);
        servicePoint.setCity(this);
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

    public void setName(String cityName) {
        this.name = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<ServicePoint> getServicePoints() {
        return servicePoints;
    }

    public void setServicePoints(List<ServicePoint> servicePoints) {
        this.servicePoints = servicePoints;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
