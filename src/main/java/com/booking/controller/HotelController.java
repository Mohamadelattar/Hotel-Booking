package com.booking.controller;

import com.booking.model.Hotel;
import com.booking.model.HotelPage;
import com.booking.model.HotelSearchCriteria;
import com.booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
//@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT','ROLE_MANAGER')")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public List<Hotel> getHotels()
    {
        return hotelService.findAll();
    }

    @GetMapping("/hotels/search")
    public ResponseEntity getHotelsBySearch(HotelPage hotelPage,
                                       HotelSearchCriteria hotelSearchCriteria){
        return new ResponseEntity<>(hotelService.findAllWithFilters(hotelPage, hotelSearchCriteria),
                HttpStatus.OK);
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
