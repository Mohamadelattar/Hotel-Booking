package com.booking.controller;

import com.booking.model.Person;
import com.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    private final String ROLE_CLIENT = "ROLE_CLIENT";
    private final String ROLE_ADMIN = "ROLE_ADMIN";
    private final String ROLE_MANAGER = "ROLE_MANAGER";

    @Autowired
    private PersonService personService;

    @GetMapping("/clients")
    public List<Person> getClients()
    {
        return personService.findPersonsByRole(ROLE_CLIENT);
    }
    @GetMapping("/admins")
    public List<Person> getAdmins()
    {
        return personService.findPersonsByRole(ROLE_ADMIN);
    }

    @GetMapping("/managers")
    public List<Person> getManagers()
    {
        return personService.findPersonsByRole(ROLE_MANAGER);
    }

    @GetMapping("/persons/{personId}")
    public Optional<Person> getPersonById(@PathVariable long personId)
    {
        return personService.findById(personId);
    }
}
