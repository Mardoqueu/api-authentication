package com.challenge.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class for creating a PasswordEncoder bean.
 *
 * This class is a Spring configuration that provides a bean of type
 * PasswordEncoder. It utilizes the BCrypt password hashing function to
 * encode passwords, offering a secure way to store and manage password
 * data within the application.
 */
@Configuration
public class PasswordEncoderConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
