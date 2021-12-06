package com.booking.controller;

import com.booking.model.CategoryEquipment;
import com.booking.service.CategoryEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CategoryEquipmentController {

    @Autowired
    private CategoryEquipmentService categoryEquipmentService;

    @GetMapping("/categoriesEquipments")
    public List<CategoryEquipment> getCategoriesEquipments(){
        return categoryEquipmentService.getCategoriesEquipments();
    }

    @GetMapping("/categoriesEquipments/{categoryEquipmentId}")
    public CategoryEquipment getCategoryEquipment(@PathVariable int categoryEquipmentId){
        return categoryEquipmentService.getCategoryEquipment(categoryEquipmentId);
    }

    @PostMapping("/categoriesEquipments/")
    public void addCategoryEquipment(@RequestBody CategoryEquipment categoryEquipment){
        categoryEquipmentService.saveCategoryEquipment(categoryEquipment);
    }

    @PutMapping("/categoriesEquipments/")
    public void updateCategoryEquipment(@RequestBody CategoryEquipment categoryEquipment){
        categoryEquipmentService.saveCategoryEquipment(categoryEquipment);
    }

    @DeleteMapping("/categoriesEquipments/{categoryEquipmentId}")
    public void deleteCategoryEquipment(@PathVariable int categoryEquipmentId){
        categoryEquipmentService.deleteCategoryEquipment(categoryEquipmentId);
    }

}
