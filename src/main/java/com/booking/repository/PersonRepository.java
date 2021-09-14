package com.booking.repository;

import com.booking.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findPersonByUsername(String username);

    Optional<Person> findPersonByEmail(String email);
}
