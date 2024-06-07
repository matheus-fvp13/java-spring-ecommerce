package edu.mfvp.javaspringecommerce.infrastructure.api.user.controllers;

import edu.mfvp.javaspringecommerce.domain.user.usecases.FindUserByIdUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.user.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class FinduserByIdController {
    private final FindUserByIdUseCase findUserByIdUseCase;

    public FinduserByIdController(FindUserByIdUseCase findUserByIdUseCase) {
        this.findUserByIdUseCase = findUserByIdUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        var user = findUserByIdUseCase.execute(id);
        return ResponseEntity.ok(UserResponse.fromEntity(user));
    }

}
