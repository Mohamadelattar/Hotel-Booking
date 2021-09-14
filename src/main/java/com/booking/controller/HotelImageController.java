package com.booking.controller;

import com.booking.model.HotelImage;
import com.booking.service.HotelImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelImageController {
    @Autowired
    private HotelImageService hotelImageService;

    @RequestMapping("/hotels/images/{hotelId}")
    public List<Object> getHotelImages(@PathVariable long hotelId){
        return hotelImageService.findHotelImages(hotelId);
    }

    @GetMapping("/images")
    public List<HotelImage> getHotels()
    {
        return hotelImageService.findAll();
    }

}
