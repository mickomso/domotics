package com.benimar.domotics.repository;

import com.benimar.domotics.domain.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

    public ApplicationUser findByUsername(String username);
}
