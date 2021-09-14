package com.booking.service;

import com.booking.model.City;

import java.util.List;

public interface CityService {
    public List<City> getCitiesByCountryId(Long countryId);
}
