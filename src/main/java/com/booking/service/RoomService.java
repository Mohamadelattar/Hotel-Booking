package com.booking.service;

 import com.booking.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    public List<Room> findAll();
    public Optional<Room> findById(long roomId);
    public void save(Room room);
    public void update(Room room);
    public void deleteById(long roomId);
}
