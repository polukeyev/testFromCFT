package com.test.services.services_rest_api.dao;

import com.test.services.services_rest_api.model.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDAO {

    private EntityManager entityManager;

    @Autowired
    public CityDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<City> getAllCities() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City", City.class)
                .getResultList();
        return cities;
    }

    public List<City> getCitiesOfCountry(int id) {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City where country_id = :cId", City.class)
                .setParameter("cId",id)
                .getResultList();
        return cities;
    }

    public City showOneCity(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(City.class, id);
    }
}
