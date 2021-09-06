package com.booking.controller;

import com.booking.model.Bed;
import com.booking.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BedController {
    @Autowired
    private BedService bedService;
    @GetMapping("/beds")
    public List<Bed> getBeds(){
        return bedService.findAll();
    }

    @PostMapping("/beds")
    public void save(@RequestBody Bed bed){
        bedService.save(bed);
    }
}
