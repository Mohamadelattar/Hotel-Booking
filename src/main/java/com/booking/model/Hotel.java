package com.booking.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;
    @Column(name="adress")
    private String adress;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy="hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelImage> hotelImages;
    @ManyToMany
    @JoinTable(name="hotel_category_equipment",joinColumns = @JoinColumn(name="hotel_id"), inverseJoinColumns = @JoinColumn(name="category_equipment_id"))
    private List<CategoryEquipment> categoryEquipments;


    public Hotel() {
    }

    public Hotel(String name, City city,String adress, String description) {
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.description = description;
    }
}
