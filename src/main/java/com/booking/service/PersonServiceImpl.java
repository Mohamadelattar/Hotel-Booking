package com.booking.service;

import com.booking.exception.PersonAlreadyExistsException;
import com.booking.model.Authority;
import com.booking.model.Person;
import com.booking.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findPersonsByRole(String role) {
        List<Person> persons = personRepository.findAll();
        List<Person> personsByRole = new ArrayList<>();
        // loop over Persons ==> Get Persons by Authority
        for(Person person:persons){
            List<Authority> authorities = person.getAuthorities();
            // loop over Authorities
            for(Authority authority:authorities){
                if(authority.getAuthority() == role){
                    personsByRole.add(person);
                    break;
                }
            }
        }
        return personsByRole;
    }

    @Override
    public Optional<Person> findById(long personId) {
        Optional<Person> person = personRepository.findById(personId);
        if(person.isEmpty()) return  null;
        return person;
    }

    @Override
    public void save(Person person) throws PersonAlreadyExistsException {
        // check if the user with email or username already exists
        String email = person.getEmail();
        String username = person.getUsername();
        Optional<Person> personWithEmail = personRepository.findPersonByEmail(email);
        Optional<Person> personWithUsername = personRepository.findPersonByUsername(username);
        if(!personWithEmail.isEmpty()){ // Person with email already exixts
            throw new PersonAlreadyExistsException("User with this email " + email + " already exists");
        }

        if(!personWithUsername.isEmpty()){ // Person with username already exixts
            throw new PersonAlreadyExistsException("User with this username " + username + " already exists");
        }

        personRepository.save(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void deleteById(long personId) {
        personRepository.deleteById(personId);
    }
}
