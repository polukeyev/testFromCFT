package com.test.services.services_rest_api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="services_list")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    @NotBlank
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name="servicepoints_sevices",
            joinColumns = @JoinColumn(name="services_id"),
            inverseJoinColumns = @JoinColumn(name="serv_point_id")
    )
    @JsonIgnore
    private List<ServicePoint> servicePointsList;

    public Service() {
    }

    public Service(String name) {
        this.name = name;
    }

    public void addPointToServList(ServicePoint servicePoint) {
        if (servicePoint == null) servicePointsList = new ArrayList<>();
        servicePointsList.add(servicePoint);
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

    public void setName(String serviceName) {
        this.name = serviceName;
    }

    public List<ServicePoint> getServicePointsList() {
        return servicePointsList;
    }

    public void setServicePointsList(List<ServicePoint> servicePointsList) {
        this.servicePointsList = servicePointsList;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + name + '\'' +
                '}';
    }
}
