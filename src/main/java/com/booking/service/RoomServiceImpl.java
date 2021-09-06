package com.booking.service;


import com.booking.model.Room;
import com.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(long roomId) {
        return roomRepository.findById(roomId);
    }

    @Override
    public void save(Room room) {
        System.out.println(room.toString());
        roomRepository.save(room);
    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void deleteById(long roomId) {
        roomRepository.deleteById(roomId);
    }


}
