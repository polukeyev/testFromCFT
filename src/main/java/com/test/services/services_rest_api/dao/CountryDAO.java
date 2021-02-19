package com.test.services.services_rest_api.dao;

import com.test.services.services_rest_api.model.Country;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryDAO {

    private EntityManager entityManager;

    @Autowired
    public CountryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Country> getAllCountries() {
        Session session = entityManager.unwrap(Session.class);
        List<Country> countries = session.createQuery("from Country", Country.class)
                .getResultList();
        return countries;
    }
}

/////////////////////////test methods//////////////////////////////////
//    public Country showOneCountry(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Country.class, id);
//    }
