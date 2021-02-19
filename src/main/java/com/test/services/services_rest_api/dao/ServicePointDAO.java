package com.test.services.services_rest_api.dao;

import com.test.services.services_rest_api.model.City;
import com.test.services.services_rest_api.model.Country;
import com.test.services.services_rest_api.model.Service;
import com.test.services.services_rest_api.model.ServicePoint;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServicePointDAO {
    private EntityManager entityManager;

    @Autowired
    public ServicePointDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<ServicePoint> getAllServices() {
        Session session = entityManager.unwrap(Session.class);

        List<ServicePoint> services = session.createQuery("from ServicePoint", ServicePoint.class)
                .getResultList();

        return services;
    }


    public ServicePoint showOnePoint(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(ServicePoint.class, id);
    }

    public void saveServicePoint(ServicePoint servicePoint) {
        Session session = entityManager.unwrap(Session.class);

        servicePoint.setCity(session
                .createQuery("from City where name=:name", City.class)
                .setParameter("name", servicePoint.getCity().getName())
                .getSingleResult()
        );

        servicePoint.setCountry(
                session.createQuery("from Country where name=:name", Country.class)
                .setParameter("name", servicePoint.getCountry().getName())
                .getSingleResult()
        );

        List<Service> services = new ArrayList<>();
        Service service;
        for (int i = 0; i < servicePoint.getServiceList().size(); i++) {
            service = session.createQuery("from Service where name=:name", Service.class)
                    .setParameter("name", servicePoint.getServiceList().get(i).getName())
                    .getSingleResult();
            services.add(service);
        }

        servicePoint.setServiceList(services);

        session.saveOrUpdate("servicePoint", servicePoint);
    }

    public void deleteService(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete from ServicePoint where id=:id")
                .setParameter("id",id)
                .executeUpdate();
    }
}

/////////////////////////test methods//////////////////////////////////
//    public List<ServicePoint> getServicesOfCity(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        List<ServicePoint> services = session.createQuery
//                ("from ServicePoint where city_id=:id", ServicePoint.class)
//                .setParameter("id", id)
//                .getResultList();
//
//        return services;
//    }
