package edu.mfvp.javaspringecommerce.infrastructure.api.user.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mfvp.javaspringecommerce.infrastructure.api.user.response.UserResponse;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserResponse> findAll() {
        var userResponse = new UserResponse(1L, "Matheus", "matheus@gmail.com", "(15)98090-9098");

        return ResponseEntity.ok(userResponse);
    }

}
