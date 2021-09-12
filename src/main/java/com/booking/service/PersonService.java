package com.booking.service;

import com.booking.exception.PersonAlreadyExistsException;
import com.booking.model.Authority;
import com.booking.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public List<Person> findAll();
    public List<Person> findPersonsByRole(String role);
    public Optional<Person> findById(long personId);
    public void save(Person person) throws PersonAlreadyExistsException;
    public void update(Person person);
    public void deleteById(long personId);
}
