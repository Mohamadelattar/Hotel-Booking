package com.booking.repository;

import com.booking.model.CategoryEquipment;
import java.util.List;

public interface CategoryEquipmentRepository {

    public void saveCategoryEquipment(CategoryEquipment categoryEquipment);
    public void deleteCategoryEquipment(int id);
    public CategoryEquipment getCategoryEquipment(int id);
    public List<CategoryEquipment> getCategoriesEquipments();

}
