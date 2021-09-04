package com.booking.service;

import com.booking.model.CategoryEquipment;
import com.booking.model.Equipment;
import com.booking.repository.CategoryEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryEquipmentServiceImpl implements CategoryEquipmentService{

    @Autowired
    private CategoryEquipmentRepository categoryEquipmentRepository;

    @Override
    public List<CategoryEquipment> findAll() {
        return categoryEquipmentRepository.findAll();
    }

    @Override
    public Optional<CategoryEquipment> findById(long categoryEquipmentId) {
        Optional<CategoryEquipment> categoryEquipment= categoryEquipmentRepository.findById(categoryEquipmentId);

        if(categoryEquipment.isEmpty()){
            return null;
        }

        return categoryEquipment;
    }

    @Override
    public void save(CategoryEquipment categoryEquipment) {
        categoryEquipmentRepository.save(categoryEquipment);
    }

    @Override
    public void update(CategoryEquipment categoryEquipment) {

    }

    @Override
    public void deleteById(long categoryEquipmentId) {
        categoryEquipmentRepository.deleteById(categoryEquipmentId);
    }
}
