package com.booking.controller;

import com.booking.model.Room;
import com.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return roomService.findAll();
    }
    @GetMapping("/rooms/{roomId}")
    public Optional<Room> getRooomById(@PathVariable long roomId){
        return roomService.findById(roomId);
    }
    @PostMapping("/rooms")
    public void saveRoom(@RequestBody Room room){
        roomService.save(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoom(@PathVariable long roomId){
        roomService.deleteById(roomId);
    }
}
