package com.benimar.domotics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class DomoticsApplication {

	private static final Logger logger = LoggerFactory.getLogger(DomoticsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DomoticsApplication.class, args);
		logger.info("Domotics App INITIALIZED!!!");
	}
}
