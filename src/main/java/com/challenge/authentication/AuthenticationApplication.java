package com.challenge.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The AuthenticationApplication is the entry point for the Spring Boot application.
 * This class contains the main method which uses Spring Boot's SpringApplication.run()
 * method to launch the application.
 */
@SpringBootApplication
public class AuthenticationApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}
}
