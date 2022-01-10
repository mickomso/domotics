package com.benimar.domotics.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test calling /users endpoint without authentication returns unauthorized.")
    public void authenticatingWithoutUser() throws Exception {
        mvc.perform(get("/users")).andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Test calling /users endpoint with valid authentication returns ok.")
    public void authenticatingWithValidUser() throws Exception {
        mvc.perform(get("/v1/users").with(httpBasic("admin", "admin")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test calling /users endpoint with wrong authentication returns unauthorized.")
    public void authenticatingWithInvalidUser() throws Exception {
        mvc.perform(get("/v1/users").with(httpBasic("wrong", "wrong")))
                .andExpect(status().isUnauthorized());
    }
}
