package com.booking.service;

import com.booking.model.Equipment;
import com.booking.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService{

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> findById(long equipmentId) {

        Optional<Equipment> equipment= equipmentRepository.findById(equipmentId);

        if(equipment.isEmpty()){
            return null;
        }

        return equipment;
    }

    @Override
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void update(Equipment equipment) {

    }

    @Override
    public void deleteById(long equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }
}
