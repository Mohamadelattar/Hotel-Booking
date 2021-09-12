package com.booking.repository;

import com.booking.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    public Authority findAuthorityByAuthority(String Role);
}
