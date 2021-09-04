package com.booking.controller;

import com.booking.model.CategoryEquipment;
import com.booking.service.CategoryEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryEquipmentController {

    @Autowired
    private CategoryEquipmentService categoryEquipmentService;

    @GetMapping("/categoriesEquipments")
    public List<CategoryEquipment> getCategoriesEquipments()
    {
        return categoryEquipmentService.findAll();
    }
    @GetMapping("/categoriesEquipments/{categoryEquipmentId}")
    public Optional<CategoryEquipment> getCategoryEquipmentById(@PathVariable long categoryEquipmentId)
    {
        return categoryEquipmentService.findById(categoryEquipmentId);
    }
    @PostMapping("/categoriesEquipments")
    public void saveCategoryEquipment(@RequestBody CategoryEquipment categoryEquipment) {
        categoryEquipmentService.save(categoryEquipment);
    }

    @DeleteMapping("/categoriesEquipments/{categoryEquipmentId}")
    public void deleteCategoryEquipmentById(@PathVariable long categoryEquipmentId)
    {
        categoryEquipmentService.deleteById(categoryEquipmentId);
    }
}
