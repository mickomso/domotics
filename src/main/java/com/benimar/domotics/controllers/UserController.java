package com.benimar.domotics.controllers;

import com.benimar.domotics.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        return users;
    }
}
