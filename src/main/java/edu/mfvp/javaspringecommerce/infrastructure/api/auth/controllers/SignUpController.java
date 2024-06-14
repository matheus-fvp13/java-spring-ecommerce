package edu.mfvp.javaspringecommerce.infrastructure.api.auth.controllers;

import edu.mfvp.javaspringecommerce.domain.user.usecases.CreateUserUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.auth.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class SignUpController {
    private final CreateUserUseCase createUserUseCase;

    public SignUpController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signupRequest, UriComponentsBuilder ucb) {
        var newUser = createUserUseCase.execute(signupRequest.toDomain());
        var uri = ucb.path("/users/{id}").buildAndExpand(newUser.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
