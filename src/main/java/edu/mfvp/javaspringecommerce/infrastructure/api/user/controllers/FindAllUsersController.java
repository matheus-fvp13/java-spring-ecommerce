package edu.mfvp.javaspringecommerce.infrastructure.api.user.controllers;

import edu.mfvp.javaspringecommerce.domain.user.usecases.FindAllUsersUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.user.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FindAllUsersController {
    private final FindAllUsersUseCase findAllUsersUseCase;

    public FindAllUsersController(FindAllUsersUseCase findAllUsersUseCase) {
        this.findAllUsersUseCase = findAllUsersUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
       var users = findAllUsersUseCase.execute();
       var usersResponse = users.stream().map(UserResponse::fromEntity).toList();
       return ResponseEntity.ok(usersResponse);
    }

}
