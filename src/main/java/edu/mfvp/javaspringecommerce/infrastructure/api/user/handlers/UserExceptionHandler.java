package edu.mfvp.javaspringecommerce.infrastructure.api.user.handlers;

import edu.mfvp.javaspringecommerce.domain.user.exceptions.UserNotFoundException;
import edu.mfvp.javaspringecommerce.infrastructure.shared.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        var statusCode = HttpStatus.NOT_FOUND.value();
        var error = new ErrorResponse(statusCode, Instant.now(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
