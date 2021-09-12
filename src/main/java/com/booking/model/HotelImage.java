package com.booking.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="hotel_image")
public class HotelImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="path")
    private String path;
    @ManyToOne
    @JoinColumn(name="hotel_id", nullable = false)
    @JsonManagedReference
    private Hotel hotel;

    public HotelImage() {
    }

    public HotelImage(String path, Hotel hotel) {
        this.path = path;
        this.hotel = hotel;
    }

}
