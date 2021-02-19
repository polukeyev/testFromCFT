package com.test.services.services_rest_api.controller;


import com.test.services.services_rest_api.model.City;
import com.test.services.services_rest_api.model.Country;
import com.test.services.services_rest_api.model.Service;
import com.test.services.services_rest_api.model.ServicePoint;
import com.test.services.services_rest_api.service.ProjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjController {

    @Autowired
    private ProjService projService;

    @GetMapping("/countries")
    public List<Country> showCountries() {
        List<Country> countryList = projService.getAllCountries();
        return countryList;
    }

    @GetMapping("/cities")
    public List<City> showCities() {
        List<City> cityList = projService.getAllCities();
        return cityList;
    }

    @GetMapping("/services")
    public List<Service> showServices() {
        List<Service> services = projService.getAllServices();
        return services;
    }

    @GetMapping("/servicepoints")
    public List<ServicePoint> showServicePoints() {
        List<ServicePoint> servicePoints = projService.getAllServicePoints();
        return servicePoints;
    }

    @GetMapping("/servicepoints/{servId}")
    public ServicePoint showOneService(@PathVariable("servId") int id) {
        ServicePoint servicePoint = projService.showOnePoint(id);
        return servicePoint;
    }

    @PostMapping("/servicepoints")
    public ServicePoint addNewServicePoint(@RequestBody ServicePoint servicePoint) {
        projService.saveServicePoint(servicePoint);
        return servicePoint;
    }

    @PutMapping("/servicepoints")
    public ServicePoint updateServicePoint(@RequestBody ServicePoint servicePoint) {
        projService.saveServicePoint(servicePoint);
        return servicePoint;
    }

    @DeleteMapping("/servicepoints/{servId}")
    public String deleteServicePoint(@PathVariable("servId") int id) {
        projService.deleteServicePoint(id);
        return "ServicePoint with ID = " + id + " was deleted from DB";
    }
}

/////////////////////////test methods//////////////////////////////////

//    @GetMapping("/countries/{countryId}")
//    public Country showOneCountry(@PathVariable("countryId") int id) {
//        Country country = projService.showOneCountry(id);
//        return country;
//    }

//    @GetMapping("/cities/{cityId}")
//    public City showOneCity(@PathVariable("cityId") int id) {
//        City city = projService.showOneCity(id);
//        return city;
//    }
