package com.booking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="category_equipment")
public class CategoryEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name = "city")
    @OneToMany(mappedBy = "categoryEquipment")
    private List<Equipment> equipments;

}
