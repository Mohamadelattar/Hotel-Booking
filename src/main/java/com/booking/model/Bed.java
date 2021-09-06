package com.booking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bed")
@Data
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public enum Type{
        Double , Simple
    }
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Bed() {
    }
    
    public Bed(Type type, Room room) {
        this.type = type;
        this.room = room;
    }
}
