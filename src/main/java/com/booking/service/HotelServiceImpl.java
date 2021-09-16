package com.booking.service;

import com.booking.dto.HotelRequest;
import com.booking.model.*;
import com.booking.repository.CityRepository;
import com.booking.repository.CountryRepository;
import com.booking.repository.HotelCriteriaRepository;
import com.booking.repository.HotelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HotelCriteriaRepository hotelCriteriaRepository;

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    // find Hotels by Name Search ==> using Criteria API
    @Override
    public Page<Hotel> findAllWithFilters(HotelPage hotelPage,
                                    HotelSearchCriteria hotelSearchCriteria){
        return hotelCriteriaRepository.findAllWithFilters(hotelPage, hotelSearchCriteria);
    }

    @Override
    public Optional<Hotel> findById(long hotelId) {
        Optional<Hotel> hotel= hotelRepository.findById(hotelId);

        if(hotel.isEmpty()){
            return null;
        }

        return hotel;
    }

    @Override
    public void save(ObjectNode json) {
        City city = cityRepository.getById(json.get("cityId").asLong());
        Hotel hotel = new Hotel();
        hotel.setName(json.get("name").asText());
        hotel.setCity(city);
        hotel.setDescription(json.get("description").asText());
        hotel.setAdress(json.get("adress").asText());

        ArrayList<String> images = new ObjectMapper().convertValue(json.get("images"), ArrayList.class);
        System.out.println("images : " + images);
        List<HotelImage> listImage = new ArrayList<>();

        for(String imageLink: images){
            System.out.println("images in the loop ");
            HotelImage img = new HotelImage();
            img.setHotel(hotel);
            img.setPath(imageLink);
            listImage.add(img);
        }

        hotel.setHotelImages(listImage);

        hotelRepository.save(hotel);
    }

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public void deleteById(long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public void saveHotel(HotelRequest hotelRequest) {
        Hotel hotel = hotelRequest.getHotel();
        City city = cityRepository.getById(hotelRequest.getCity_id());
        List<HotelImage> hotelImageList = hotelRequest.getHotelImageList();

        for(HotelImage hotelImage: hotelImageList){
            hotelImage.setHotel(hotel);
        }

        hotel.setHotelImages(hotelImageList);
        hotel.setCity(city);

        hotelRepository.save(hotel);
    }

    private void addImageToHotel(Hotel hotel, HotelImage hotelImage){
        hotelImage.setHotel(hotel);
    }
}
