package com.booking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="hotel_image")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class HotelImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="path")
    private String path;
    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    public HotelImage() {
    }

    public HotelImage(String path, Hotel hotel) {
        this.path = path;
        this.hotel = hotel;
    }

}
