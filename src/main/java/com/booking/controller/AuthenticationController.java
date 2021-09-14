package com.booking.controller;

import com.booking.model.AuthenticationResponse;
import com.booking.model.Authority;
import com.booking.model.Person;
import com.booking.security.JwtUtil;
import com.booking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PersonService personService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> login(@RequestBody Person person) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(person.getUsername(),person.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(person.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        final String username = person.getUsername();

        System.out.println("usernmae is : " + username);

        final String ROLE = personService.getPersonRole(username);

        System.out.println("Role is : " + ROLE);

        return ResponseEntity.ok(new AuthenticationResponse(jwt,ROLE));
    }
}
