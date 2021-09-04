package com.booking.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="category_equipment_id")
    private CategoryEquipment categoryEquipment;

}
