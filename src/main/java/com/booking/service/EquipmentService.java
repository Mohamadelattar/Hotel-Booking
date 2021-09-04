package com.booking.service;

import com.booking.model.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    public List<Equipment> findAll();
    public Optional<Equipment> findById(long equipmentId);
    public void save(Equipment equipment);
    public void update(Equipment equipment);
    public void deleteById(long equipmentId);
}
