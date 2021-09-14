package com.booking.service;

import com.booking.model.Hotel;
import com.booking.model.HotelImage;
import com.booking.model.HotelPage;
import com.booking.model.HotelSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelImageService {
    public List<HotelImage> findAll();
    public List<Object> findHotelImages(long hotelId);

}
