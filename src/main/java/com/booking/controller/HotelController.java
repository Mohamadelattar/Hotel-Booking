package com.booking.controller;

import com.booking.model.Hotel;
import com.booking.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public List<Hotel> fetchAlHotels()
    {
        return hotelService.getAllHotels();
    }
    @PostMapping
    public void registerHotel(Hotel hotel) {
        hotelService.addNewHotel(hotel);
    }


}
