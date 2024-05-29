package edu.mfvp.javaspringecommerce.domain.category.exceptions;

public class CategoryNameAlreadyExistsException extends RuntimeException {
    public CategoryNameAlreadyExistsException(String name) {
        super("Category with name %s already exists: ".formatted(name));
    }
}
