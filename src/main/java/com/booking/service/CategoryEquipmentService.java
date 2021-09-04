package com.booking.service;

import com.booking.model.CategoryEquipment;

import java.util.List;
import java.util.Optional;

public interface CategoryEquipmentService {

    public List<CategoryEquipment> findAll();
    public Optional<CategoryEquipment> findById(long categoryEquipmentId);
    public void save(CategoryEquipment categoryEquipment);
    public void update(CategoryEquipment categoryEquipment);
    public void deleteById(long categoryEquipmentId);
}
