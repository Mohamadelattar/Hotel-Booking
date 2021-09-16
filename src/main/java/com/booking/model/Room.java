package com.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "person_number")
    private int personNumber;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<RoomImage> roomImageList;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Bed> bedList;


    public Room() {

    }

    public Room(String type, int personNumber, double price, Hotel hotel) {
        this.type = type;
        this.personNumber = personNumber;
        this.price = price;
        this.hotel = hotel;
    }
}
