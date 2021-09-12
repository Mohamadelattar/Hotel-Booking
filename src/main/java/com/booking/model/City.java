package com.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private List<Hotel> hotels;
    @ManyToOne
    @JoinColumn(name="country_id")
    @JsonManagedReference
    private Country country;


    public City() {
    }

    public City(String name) {
        this.name = name;

    }
}
