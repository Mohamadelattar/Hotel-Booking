package com.booking.service;

import com.booking.model.Equipment;
import com.booking.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    public List<Hotel> findAll();
    public Optional<Hotel> findById(long hotelId);
    public void save(Hotel hotel);
    public void update(Hotel hotel);
    public void deleteById(long hotelId);
}
