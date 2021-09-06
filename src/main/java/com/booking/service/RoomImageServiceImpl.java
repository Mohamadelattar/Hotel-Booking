package com.booking.service;

import com.booking.model.RoomImage;
import com.booking.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomImageServiceImpl implements RoomImageService{
    @Autowired
    private RoomImageRepository roomImageRepository;
    @Override
    public List<RoomImage> findAll() {
        return roomImageRepository.findAll();
    }

    @Override
    public Optional<RoomImage> findById(long roomImageId) {
        return roomImageRepository.findById(roomImageId);
    }

    @Override
    public void save(RoomImage roomImage) {
        roomImageRepository.save(roomImage);
    }

    @Override
    public void update(RoomImage roomImage) {

    }

    @Override
    public void deleteById(long roomImageId) {
        roomImageRepository.deleteById(roomImageId);
    }
}
