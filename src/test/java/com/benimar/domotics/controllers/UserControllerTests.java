package com.benimar.domotics.controllers;

import com.benimar.domotics.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserControllerTests {

    @Autowired
    private UserController userController;

    @Test
    public void findAllUsers() {
        List<User> users = userController.findAll();
        assertEquals(users.size(), 0);
    }
}
