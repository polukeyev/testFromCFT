package com.test.services.services_rest_api.service;

import com.test.services.services_rest_api.dao.CityDAO;
import com.test.services.services_rest_api.dao.CountryDAO;
import com.test.services.services_rest_api.dao.ServiceDAO;
import com.test.services.services_rest_api.dao.ServicePointDAO;
import com.test.services.services_rest_api.model.City;
import com.test.services.services_rest_api.model.Country;
import com.test.services.services_rest_api.model.ServicePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjService {

    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private CountryDAO countryDAO;
    @Autowired
    private ServicePointDAO servicePointDAO;
    @Autowired
    private ServiceDAO serviceDAO;

    @Transactional
    public List<Country> getAllCountries() {
        return countryDAO.getAllCountries();
    }

    @Transactional
    public List<City> getAllCities() {
        return cityDAO.getAllCities();
    }

    @Transactional
    public List<com.test.services.services_rest_api.model.Service> getAllServices() {
        return serviceDAO.getAllServices();
    }

    @Transactional
    public List<ServicePoint> getAllServicePoints() {
        return servicePointDAO.getAllServices();
    }

    @Transactional
    public ServicePoint showOnePoint(int id) {
        return servicePointDAO.showOnePoint(id);
    }

    @Transactional
    public void saveServicePoint(ServicePoint servicePoint) {
        servicePointDAO.saveServicePoint(servicePoint);
    }

    @Transactional
    public void deleteServicePoint(int id) {
        servicePointDAO.deleteService(id);
    }
}

/////////////////////////test methods//////////////////////////////////

//    @Transactional
//    public List<City> getCitiesOfCountry(int id) {
//        return cityDAO.getCitiesOfCountry(id);
//    }
//
//    @Transactional
//    public List<ServicePoint> getServicesOfCity(int id) {
//        return servicePointDAO.getServicesOfCity(id);
//    }

//    @Transactional
//    public Country showOneCountry(int id) {
//        return countryDAO.showOneCountry(id);
//    }
//
//    @Transactional
//    public City showOneCity(int id) {
//        return cityDAO.showOneCity(id);
//    }
