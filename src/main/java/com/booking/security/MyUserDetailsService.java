package com.booking.security;

import com.booking.model.Person;
import com.booking.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Optional<Person> person = personRepository.findPersonByUsername(username);

        if(person == null) {
            throw new UsernameNotFoundException("username not Found : "+ username);
        }

        return person.map(MyUserDetails::new).get();
    }
}
