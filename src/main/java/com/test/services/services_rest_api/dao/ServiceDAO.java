package com.test.services.services_rest_api.dao;

import com.test.services.services_rest_api.model.Service;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ServiceDAO {

    private EntityManager entityManager;

    @Autowired
    public ServiceDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Service> getAllServices() {
        Session session = entityManager.unwrap(Session.class);

        List<Service> serviceList = session.createQuery("from Service",
                com.test.services.services_rest_api.model.Service.class)
                .getResultList();

        return serviceList;
    }
}