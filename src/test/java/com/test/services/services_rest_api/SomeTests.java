package com.test.services.services_rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.services.services_rest_api.controller.ProjController;
import com.test.services.services_rest_api.model.City;
import com.test.services.services_rest_api.model.Country;
import com.test.services.services_rest_api.model.Service;
import com.test.services.services_rest_api.model.ServicePoint;
import com.test.services.services_rest_api.service.ProjService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ProjController.class)
class SomeTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjService projService;

    @Test
    public void showCountriesTest() throws Exception {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Russia"));
        countries.get(0).setId(1);
        countries.add(new Country("Morocco"));
        countries.get(1).setId(2);
        countries.add(new Country("Albania"));
        countries.get(2).setId(3);

        Mockito.when(projService.getAllCountries()).thenReturn(countries);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse = objectMapper.writeValueAsString(countries);

        Assert.assertEquals(expectedJsonResponse, actualJsonResponse);
    }

    @Test
    public void showCitiesTest() throws Exception {
        Country russia = new Country("Russia");
        russia.setId(1);
        Country gB = new Country("GreatBritain");
        gB.setId(2);

        List<City> cities = new ArrayList<>();
        cities.add(new City("Moscow"));
        cities.get(0).setId(1);
        cities.get(0).setCountry(russia);
        cities.add(new City("Novosibirsk"));
        cities.get(1).setId(2);
        cities.get(1).setCountry(russia);
        cities.add(new City("York"));
        cities.get(2).setId(3);
        cities.get(2).setCountry(gB);


        Mockito.when(projService.getAllCities()).thenReturn(cities);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cities"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse = objectMapper.writeValueAsString(cities);

        Assert.assertEquals(expectedJsonResponse, actualJsonResponse);
    }

    @Test
    public void addNewServicePointsTest() throws Exception {
        Country country = new Country("Russia");
        City city = new City("Moscow");
        List<Service> services = new ArrayList<>();
        services.add(new Service("Excursions"));
        services.add(new Service("Money changing"));

        ServicePoint servicePoint = new ServicePoint();
        servicePoint.setName("Test service point");
        servicePoint.setAddress("Test address");
        servicePoint.setCountry(country);
        servicePoint.setCity(city);
        servicePoint.setServiceList(services);

        String jsonRequest =
                "{\n" +
                        "    \"name\" : \"Test service point\",\n" +
                        "    \"address\" : \"Test address\",\n" +
                        "    \"serviceList\" : [\n" +
                        "        {\n" +
                        "            \"name\" : \"Excursions\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"name\" : \"Money changing\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"city\" : {\n" +
                        "        \"name\" : \"Moscow\"\n" +
                        "    },\n" +
                        "    \"country\" : {\n" +
                        "        \"name\" : \"Russia\"\n" +
                        "    }\n" +
                        "}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/servicepoints")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String actualJsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedJsonResponse = objectMapper.writeValueAsString(servicePoint);

        Assert.assertEquals(expectedJsonResponse, actualJsonResponse);
    }
}