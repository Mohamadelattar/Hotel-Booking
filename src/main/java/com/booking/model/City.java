package com.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="location")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy="city")
    private List<Hotel> hotels;
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;


    public City() {
    }

    public City(String name) {
        this.name = name;

    }
}
