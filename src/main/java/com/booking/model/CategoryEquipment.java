package com.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<Equipment> equipments;
    @ManyToMany
    @JoinTable(name="hotel_category_equipment",joinColumns = @JoinColumn(name="category_equipment_id"), inverseJoinColumns = @JoinColumn(name="hotel_id"))
    @JsonBackReference
    private List<Hotel> hotels;

}
