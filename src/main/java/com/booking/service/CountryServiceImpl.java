package com.booking.service;

import com.booking.model.Country;
import com.booking.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
