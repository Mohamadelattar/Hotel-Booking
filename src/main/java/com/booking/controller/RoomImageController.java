package com.booking.controller;

import com.booking.model.RoomImage;
import com.booking.service.RoomImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomImageController {

    @Autowired
    private RoomImageService roomImageService;
    @GetMapping("/roomImages")
    public List<RoomImage> getRoomImages(){
        return roomImageService.findAll();
    }
}
