package com.booking.service;

import com.booking.model.City;
import com.booking.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> getCitiesByCountryId(Long countryId) {
        List<City> cities = cityRepository.findAll();
        List<City> citiesByCountryId = new ArrayList<>();

        for(City city: cities){
            if(city.getCountry().getId() == countryId){
                // Add city to our new List
                citiesByCountryId.add(city);
            }
        }

        return citiesByCountryId;
    }
}
