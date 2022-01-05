package com.benimar.domotics.controllers;

import com.benimar.domotics.domain.ApplicationUser;
import com.benimar.domotics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<ApplicationUser> findAll() {
        return (List<ApplicationUser>) userRepository.findAll();
    }
}
