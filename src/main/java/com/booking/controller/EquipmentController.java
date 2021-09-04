package com.booking.controller;

import com.booking.model.Equipment;
import com.booking.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/equipments")
    public List<Equipment> getEquipments()
    {
        return equipmentService.findAll();
    }
    @GetMapping("/equipments/{equipmentId}")
    public Optional<Equipment> getEquipmentById(@PathVariable long equipmentId)
    {
        return equipmentService.findById(equipmentId);
    }
    @PostMapping("/equipments")
    public void saveEquipment(@RequestBody Equipment equipment) {
        equipmentService.save(equipment);
    }

    @DeleteMapping("/equipments/{equipmentId}")
    public void deleteEquipmentById(@PathVariable long equipmentId)
    {
        equipmentService.deleteById(equipmentId);
    }
}
