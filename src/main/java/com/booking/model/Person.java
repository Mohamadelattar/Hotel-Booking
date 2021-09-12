package com.booking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="identity_number")
    private String identityNumber;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="phone_number")
    private String phoneNumber;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="person_authority",
                joinColumns = @JoinColumn(name="person_id"),
                inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities;
}
