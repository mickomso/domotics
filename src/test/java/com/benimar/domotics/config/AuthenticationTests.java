package com.benimar.domotics.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    public void givenNoUser_shouldFailedWith401() throws Exception {
        mvc.perform(get("/users")).andExpect(status().isUnauthorized());
    }

    @ParameterizedTest
    @CsvSource(value = {"user, user", "admin, admin"})
    public void givenValidUser_shouldSucceedWith200(String user, String password) throws Exception {
        mvc.perform(get("/v1/users").with(httpBasic(user, password))).andExpect(status().isOk());
    }

    @ParameterizedTest
    @CsvSource(value = {"user, admin", "admin, user", "wrong, wrong"})
    public void givenInvalidUser_shouldFailedWith401(String user, String password) throws Exception {
        mvc.perform(get("/v1/users").with(httpBasic(user, password))).andExpect(status().isUnauthorized());
    }
}
