package com.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room_image")
@Data
public class RoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "path")
    private String path;
    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    @JsonBackReference
    private Room room;

    public RoomImage() {
    }

    public RoomImage(String path, Room room) {
        this.path = path;
        this.room = room;
    }
}
