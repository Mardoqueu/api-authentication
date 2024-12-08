package com.challenge.authentication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * AuthRequestDTO is a Data Transfer Object used for carrying authentication
 * request data between processes. This class is typically used in
 * authentication operations, such as login requests, where it encapsulates
 * the necessary information required for user authentication.
 *
 * The object contains two primary fields for authentication:
 * - A username, which is required to be a non-blank string with a length
 *   between 3 and 30 characters.
 * - A password, which must also be a non-blank string with a maximum length
 *   of 10 characters.
 *
 * The class provides a default constructor, a parameterized constructor for
 * initializing the username and password, as well as getter and setter methods
 * for accessing and modifying the fields.
 */
public class AuthRequestDTO {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    @Size(max = 10, message = "The password must be less than 10 characters")
    private String password;

    public AuthRequestDTO() {}

    public AuthRequestDTO(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
