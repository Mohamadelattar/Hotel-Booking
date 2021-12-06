package com.booking.repository;

import com.booking.model.Equipment;

import java.util.List;

public interface EquipmentRepository {

    public void saveEquipment(Equipment categoryEquipment);
    public void deleteEquipment(int id);
    public Equipment getEquipment(int id);
    public List<Equipment> getEquipments();

}
