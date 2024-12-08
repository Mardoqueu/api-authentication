package com.challenge.authentication.dto;

/**
 * AuthResponseDTO is a Data Transfer Object used to encapsulate the
 * response data for an authentication operation. It is typically used
 * to convey authentication results, specifically a token and a user ID,
 * from the server to the client after a successful login or authentication
 * request.
 *
 * This class contains the following properties:
 * - token: A string representing the authentication token, which clients
 *   use for further authenticated requests.
 * - userId: A long value representing the unique identifier of the
 *   authenticated user.
 *
 * The class provides a parameterized constructor for initializing both
 * fields and includes getter and setter methods for accessing and modifying
 * these properties.
 */
public class AuthResponseDTO {
    private String token;
    private Long userId;

    public AuthResponseDTO(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

