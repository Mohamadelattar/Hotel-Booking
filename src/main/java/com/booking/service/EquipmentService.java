package com.booking.service;

import com.booking.model.CategoryEquipment;
import com.booking.model.Equipment;

import java.util.List;

public interface EquipmentService {

    public List<Equipment> getEquipments();
    public void saveCategoryEquipment(Equipment equipment);
    public Equipment getEquipment(int id);
    public void deleteEquipment(int id);

}
