package edu.mfvp.javaspringecommerce.domain.user.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException {
    public UserEmailAlreadyExistsException(String email) {
        super("E-mail already exists: " + email);
    }
}
