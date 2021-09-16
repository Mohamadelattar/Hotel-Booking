package com.booking.controller;

import com.booking.dto.HotelRequest;
import com.booking.model.Hotel;
import com.booking.model.HotelPage;
import com.booking.model.HotelSearchCriteria;
import com.booking.service.HotelService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Save Hotel and All his details ( images - rooms - city - country ... )
    @PostMapping(value = "/hotels")
    public void saveHotel(@RequestBody ObjectNode json) {
        hotelService.save(json);
    }

    // FOR TEST
    @PostMapping(value = "/hotels/save")
    public void saveHotel(@RequestBody HotelRequest hotelRequest) {
        System.out.println("im in the controler");
        hotelService.saveHotel(hotelRequest);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotelById(@PathVariable long hotelId)
    {
        hotelService.deleteById(hotelId);
    }


}
