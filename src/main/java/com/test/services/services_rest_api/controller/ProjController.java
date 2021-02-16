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

    @GetMapping("/countries/{countryId}")
    public Country showOneCountry(@PathVariable("countryId") int id) {
        Country country = projService.showOneCountry(id);
        return country;
    }

    @GetMapping("/cities")
    public List<City> showCities() {
        List<City> cityList = projService.getAllCities();
        return cityList;
    }

    @GetMapping("/cities/{cityId}")
    public City showOneCity(@PathVariable("cityId") int id) {
        City city = projService.showOneCity(id);
        return city;
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

//
//
////-************************************************************************
//    @GetMapping("/countries/cities/{cityId}")
//    public String showServices(@PathVariable("cityId") int id, Model model) {
//        model.addAttribute("servicesOfCity", projService.getServicesOfCity(id));
//        model.addAttribute("countryId", getCountryId());
//        cityId = id;
//        return "/servicepoints";
//    }
////-----------------------------------------------------------
//    @GetMapping("/countries/cities/addservice")
//    public String addService(@ModelAttribute("servicePoint") ServicePoint servicePoint) {
//        return "/addservice";
//    }
//
//    @PostMapping("/countries/cities/servicepoints")
//    public String createService(@ModelAttribute("servicePoint") ServicePoint servicePoint,
//                                BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) return "/countries/cities/addservice";
//
//        projService.saveServicePoint(servicePoint, getCityId(), getCountryId());
//        return "redirect:/countries/cities/"+getCityId();
//    }
////------------------------------------------------------------
//    @GetMapping("/countries/cities/servicepoints/{serviceId}")
//    public String showService(@PathVariable("serviceId") int id, Model model) {
//        model.addAttribute("servicePoint", projService.showOnePoint(id));
//        return "/point";
//    }
////------------------------------------------------------------
//
//    @GetMapping("/countries/cities/servicepoints/{serviceId}/editservice")
//    public String editService(Model model, @PathVariable("serviceId") int id) {
//        model.addAttribute("servicePoint",projService.showOnePoint(id));
//        return "/editservice";
//
//    }
//
//    @PatchMapping("/countries/cities/servicepoints/")
//    public String updateService(@ModelAttribute("servicePoint") @Valid ServicePoint servicePoint,
//                                BindingResult bindingResult,
//                                @RequestParam("cityId") int cityId, @RequestParam("countryId") int countryId) {
//        if (bindingResult.hasErrors()) return "/countries/cities/servicepoints/editservice";
//
//        projService.updateServicePoint(servicePoint, cityId, countryId);
//        return "redirect:/countries/cities/"+cityId;
//    }
//
//    @DeleteMapping("/countries/cities/servicepoints/{serviceId}")
//    public String deleteService(@PathVariable("serviceId") int id) {
//        projService.deleteService(id);
//        return "redirect:/countries/cities/"+getCityId();
//    }
//
//    public static int getCountryId() {
//        return countryId;
//    }
//
//    public static int getCityId() {
//        return cityId;
//    }
//}
