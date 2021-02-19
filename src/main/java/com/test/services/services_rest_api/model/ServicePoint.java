package com.test.services.services_rest_api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class ServicePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Service name should be not empty")
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH},
    fetch = FetchType.EAGER)
    @JoinTable(
            name="servicepoints_sevices",
            joinColumns = @JoinColumn(name="serv_point_id"),
            inverseJoinColumns = @JoinColumn(name="services_id")
    )
    private List<Service> serviceList;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Country country;


    public ServicePoint() {
    }

    public ServicePoint(String name, String address, List<Service> serviceList, City city, Country country) {
        this.name = name;
        this.address = address;
        this.serviceList = serviceList;
        this.city = city;
        this.country = country;
    }

    public void addServiceToPoint(Service service) {
        if (serviceList == null) serviceList = new ArrayList<>();
        serviceList.add(service);
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

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ServicePoint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", serviceList=" + serviceList +
                ", city=" + city +
                ", country=" + country +
                '}';
    }
}
