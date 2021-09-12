package com.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
    @ManyToMany
    @JoinTable(name="person_authority",
            joinColumns = @JoinColumn(name="authority_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    @JsonBackReference
    private List<Person> persons;

    public Authority() {
    }
}
