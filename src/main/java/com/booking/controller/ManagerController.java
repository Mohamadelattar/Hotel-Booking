package com.booking.controller;

import com.booking.exception.PersonAlreadyExistsException;
import com.booking.model.Person;
import com.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manage")
@CrossOrigin(origins = "http://localhost:3000")
public class ManagerController {

    private final String ROLE_MANAGER = "ROLE_MANAGER";

    @Autowired
    private PersonService personService;

    @GetMapping("/managers")
    public List<Person> getManagers()
    {
        return personService.findPersonsByRole(ROLE_MANAGER);
    }
    @GetMapping("/managers/{managerId}")
    public Optional<Person> getManagerById(@PathVariable long managerId)
    {
        return personService.findById(managerId);
    }
    // Add new Person ==> Sign Up
    @PostMapping("/managers/register")
    public void saveManager(@RequestBody Person person) throws PersonAlreadyExistsException {
        personService.save(person,ROLE_MANAGER);
    }

    @DeleteMapping("/managers/{managerId}")
    public void deleteManagerById(@PathVariable long managerId)
    {
        personService.deleteById(managerId);
    }
}
