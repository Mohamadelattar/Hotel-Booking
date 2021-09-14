package com.booking.service;


import com.booking.model.HotelImage;
import com.booking.repository.HotelImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelImageServiceImpl implements HotelImageService{

    @Autowired
    private HotelImageRepository hotelImageRepository;

    @Override
    public List<HotelImage> findAll() {
        return hotelImageRepository.findAll();
    }

    @Override
    public List<Object> findHotelImages(long hotelId) {
        return hotelImageRepository.findByHotel(hotelId);
    }


}
