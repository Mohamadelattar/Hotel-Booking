package com.booking.repository;

import com.booking.model.Hotel;
import com.booking.model.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface HotelImageRepository  extends JpaRepository<HotelImage, Long> {

    @Query("SELECT i FROM HotelImage i WHERE i.hotel.id = :hotelId ")
    List<Object> findByHotel(long hotelId);


}
