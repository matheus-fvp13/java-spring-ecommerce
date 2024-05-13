package edu.mfvp.javaspringecommerce.domain.user.exceptions;

public class UserEmailAlreadyExists extends RuntimeException {
    public UserEmailAlreadyExists(String email) {
        super("E-mail already exists: " + email);
    }
}
