package com.booking.service;

import com.booking.model.Equipment;
import com.booking.model.Hotel;
import com.booking.model.HotelPage;
import com.booking.model.HotelSearchCriteria;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    public List<Hotel> findAll();
    public Page<Hotel> findAllWithFilters(HotelPage hotelPage,HotelSearchCriteria hotelSearchCriteria);
    public Optional<Hotel> findById(long hotelId);
    public void save(Hotel hotel);
    public void update(Hotel hotel);
    public void deleteById(long hotelId);
}
