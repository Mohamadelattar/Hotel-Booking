package com.booking.controller;

import com.booking.model.Authority;
import com.booking.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/authorities/{role}")
    public Authority getAuthority(@PathVariable String role){
        return  authorityService.findAuthorityByRole(role);
    }
}
