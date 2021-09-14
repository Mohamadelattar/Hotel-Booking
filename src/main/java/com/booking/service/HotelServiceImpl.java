package com.booking.service;

import com.booking.model.*;
import com.booking.repository.HotelCriteriaRepository;
import com.booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
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
    public void save(Hotel hotel) {

        for(HotelImage hotelImage : hotel.getHotelImages() ){
            addImageToHotel(hotel,hotelImage);
        }
        hotelRepository.save(hotel);
    }

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public void deleteById(long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    private void addImageToHotel(Hotel hotel, HotelImage hotelImage){
        hotelImage.setHotel(hotel);
    }
}
