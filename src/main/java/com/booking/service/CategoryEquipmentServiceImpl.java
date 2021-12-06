package com.booking.service;

import com.booking.model.CategoryEquipment;
import com.booking.model.Hotel;
import com.booking.repository.CategoryEquipmentRepository;
import com.booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryEquipmentServiceImpl implements CategoryEquipmentService{

    @Autowired
    private CategoryEquipmentRepository categoryEquipmentRepository;

    @Transactional
    public List<CategoryEquipment> getCategoriesEquipments() {
        return categoryEquipmentRepository.getCategoriesEquipments();
    }

    @Transactional
    public void saveCategoryEquipment(CategoryEquipment categoryEquipment) {
        categoryEquipmentRepository.saveCategoryEquipment(categoryEquipment);
    }

    @Transactional
    public CategoryEquipment getCategoryEquipment(int id) {
        return categoryEquipmentRepository.getCategoryEquipment(id);
    }

    @Transactional
    public void deleteCategoryEquipment(int id) {
        categoryEquipmentRepository.deleteCategoryEquipment(id);
    }
}
