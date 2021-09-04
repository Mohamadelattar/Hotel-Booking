package com.booking.repository;

import com.booking.model.CategoryEquipment;
import com.booking.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository  extends JpaRepository<Equipment, Long> {
}
