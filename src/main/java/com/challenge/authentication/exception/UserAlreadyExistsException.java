package com.challenge.authentication.exception;

/**
 * UserAlreadyExistsException is a custom exception that extends RuntimeException.
 * It is thrown when there is an attempt to create a user that already exists
 * in the system.
 *
 * This exception is typically used in user registration processes to indicate
 * that the username provided is already taken and cannot be used again.
 *
 * The exception carries a message that provides additional context or detail
 * about the specific cause or circumstance of the exception being thrown.
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}