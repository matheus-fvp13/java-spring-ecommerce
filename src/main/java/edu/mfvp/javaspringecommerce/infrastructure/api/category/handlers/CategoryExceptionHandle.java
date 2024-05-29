package edu.mfvp.javaspringecommerce.infrastructure.api.category.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.mfvp.javaspringecommerce.domain.category.exceptions.CategoryNameAlreadyExistsException;
import edu.mfvp.javaspringecommerce.infrastructure.shared.error.ErrorResponse;

@ControllerAdvice
public class CategoryExceptionHandle {

    @ExceptionHandler(CategoryNameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handle(CategoryNameAlreadyExistsException exception) {
        var errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), Instant.now(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }
    
}
