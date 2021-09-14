package com.booking.repository;

import com.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT i FROM Room i WHERE i.hotel.id = :hotelId ")
    List<Object> findByHotel(long hotelId);
}
