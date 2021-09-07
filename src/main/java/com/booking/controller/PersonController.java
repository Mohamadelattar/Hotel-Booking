package com.booking.controller;

import com.booking.exception.PersonAlreadyExistsException;
import com.booking.model.Person;
import com.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons()
    {
        return personService.findAll();
    }
    @GetMapping("/persons/{personId}")
    public Optional<Person> getPersonById(@PathVariable long personId)
    {
        return personService.findById(personId);
    }
    // Add new Person ==> Sign Up
    @PostMapping("/persons/sign-up")
    public void savePerson(@RequestBody Person person) throws PersonAlreadyExistsException {
        personService.save(person);
    }

    @DeleteMapping("/persons/{personId}")
    public void deletePersonById(@PathVariable long personId)
    {
        personService.deleteById(personId);
    }
}
