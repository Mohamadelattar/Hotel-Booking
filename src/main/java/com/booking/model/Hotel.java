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
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy="hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelImage> hotelImages;


    public Hotel() {
    }

    public Hotel(String name, String city, String address, String description) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.description = description;
    }
}
