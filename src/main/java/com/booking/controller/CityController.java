package com.booking.controller;

import com.booking.model.City;
import com.booking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/by_country")
    public List<City> getCitiesByCountry(@RequestParam Long countryId){
        return cityService.getCitiesByCountryId(countryId);
    }
}
