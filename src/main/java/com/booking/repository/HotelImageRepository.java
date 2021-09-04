package com.booking.repository;

import com.booking.model.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelImageRepository  extends JpaRepository<HotelImage, Long> {
}
