package com.booking.controller;

import com.booking.exception.PersonAlreadyExistsException;
import com.booking.model.Person;
import com.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    @Autowired
    private PersonService personService;

    @GetMapping("/clients")
    public List<Person> getClients()
    {
        return personService.findAll();
    }
    @GetMapping("/clients/{clientId}")
    public Optional<Person> getClientById(@PathVariable long clientId)
    {
        return personService.findById(clientId);
    }
    // Add new Person ==> Sign Up
    @PostMapping("/clients/register")
    public void saveClient(@RequestBody Person person) throws PersonAlreadyExistsException {
        personService.save(person);
    }

    @DeleteMapping("/clients/{clientId}")
    public void deleteClientById(@PathVariable long clientId)
    {
        personService.deleteById(clientId);
    }
}
