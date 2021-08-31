package com.booking.service;

import com.booking.model.Hotel;
import com.booking.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    @Transactional
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    // insett ?????
    public void addNewHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }
}
