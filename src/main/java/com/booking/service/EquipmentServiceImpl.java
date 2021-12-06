package com.booking.service;

import com.booking.model.Equipment;
import com.booking.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EquipmentServiceImpl implements EquipmentService{

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getEquipments() {
        return equipmentRepository.getEquipments();
    }

    @Override
    public void saveCategoryEquipment(Equipment equipment) {
        equipmentRepository.saveEquipment(equipment);
    }

    @Override
    public Equipment getEquipment(int id) {
        return equipmentRepository.getEquipment(id);
    }

    @Override
    public void deleteEquipment(int id) {
        equipmentRepository.deleteEquipment(id);
    }
}
