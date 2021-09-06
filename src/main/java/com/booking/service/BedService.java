package com.booking.service;

import com.booking.model.Bed;
import com.booking.model.RoomImage;

import java.util.List;
import java.util.Optional;

public interface BedService {
    public List<Bed> findAll();
    public Optional<Bed> findById(long bedId);
    public void save(Bed bed);
    public void update(Bed bed);
    public void deleteById(long bedId);
}
