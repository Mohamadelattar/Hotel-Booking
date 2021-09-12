package com.booking.service;

import com.booking.model.Authority;
import com.booking.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority findAuthorityByRole(String Role) {
        return authorityRepository.findAuthorityByAuthority(Role);
    }
}
