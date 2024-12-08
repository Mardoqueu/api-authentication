package com.challenge.authentication.exception;

/**
 * InvalidCredentialsException is a custom exception that extends RuntimeException.
 * It is thrown when authentication fails due to invalid user credentials.
 *
 * This exception is typically used in the context of user authentication
 * processes, where it indicates that the provided credentials do not match
 * any existing user records, resulting in an unauthorized access attempt.
 *
 * A common use case would be throwing this exception within methods responsible
 * for user login, particularly when user authentication finishes unsuccessfully
 * due to incorrect username or password inputs.
 */
public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}