package com.booking.repository;

import com.booking.model.CategoryEquipment;
import com.booking.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEquipmentRepository extends JpaRepository<CategoryEquipment, Long> {
}
