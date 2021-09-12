package com.booking.controller;

import com.booking.model.Hotel;
import com.booking.service.HotelService;
import com.booking.service.HotelServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public List<Hotel> getHotels()
    {
        return hotelService.findAll();
    }
    @GetMapping("/hotels/{hotelId}")
    public Optional<Hotel> getHotelById(@PathVariable long hotelId)
    {
        return hotelService.findById(hotelId);
    }
    @PostMapping("/hotels")
    public void saveHotel(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotelById(@PathVariable long hotelId)
    {
        hotelService.deleteById(hotelId);
    }


}
