package com.booking.service;

import com.booking.model.Bed;
import com.booking.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedServiceImpl implements BedService{
    @Autowired
    private BedRepository bedRepository;
    @Override
    public List<Bed> findAll() {
        return bedRepository.findAll();
    }

    @Override
    public Optional<Bed> findById(long bedId) {
        return bedRepository.findById(bedId);
    }

    @Override
    public void save(Bed bed) {
        bedRepository.save(bed);
    }

    @Override
    public void update(Bed bed) {

    }

    @Override
    public void deleteById(long bedId) {
        bedRepository.deleteById(bedId);
    }
}
