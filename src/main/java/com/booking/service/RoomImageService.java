package com.booking.service;

import com.booking.model.RoomImage;
import java.util.List;
import java.util.Optional;

public interface RoomImageService {
    public List<RoomImage> findAll();
    public Optional<RoomImage> findById(long roomImageId);
    public void save(RoomImage roomImage);
    public void update(RoomImage roomImage);
    public void deleteById(long roomImageId);
}
