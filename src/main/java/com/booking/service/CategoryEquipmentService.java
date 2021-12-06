package com.booking.service;

import com.booking.model.CategoryEquipment;

import java.util.List;

public interface CategoryEquipmentService {

    public List<CategoryEquipment> getCategoriesEquipments();
    public void saveCategoryEquipment(CategoryEquipment categoryEquipment);
    public CategoryEquipment getCategoryEquipment(int id);
    public void deleteCategoryEquipment(int id);
}
