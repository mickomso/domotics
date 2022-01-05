package com.benimar.domotics;

import com.benimar.domotics.domain.ApplicationUser;
import com.benimar.domotics.domain.Role;
import com.benimar.domotics.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DomoticsApplication {

	private static final Logger logger = LoggerFactory.getLogger(DomoticsApplication.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomoticsApplication.class, args);
		logger.info("Domotics App INITIALIZED!!!");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// username: user password: user
			userRepository.save(new ApplicationUser("user",
					"$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
					Role.ROLE_USER));
			// username: admin password: admin
			userRepository.save(new ApplicationUser("admin",
					"$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
					Role.ROLE_ADMIN));
		};
	}
}
