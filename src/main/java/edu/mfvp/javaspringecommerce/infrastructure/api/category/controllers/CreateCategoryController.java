package edu.mfvp.javaspringecommerce.infrastructure.api.category.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mfvp.javaspringecommerce.domain.category.usecases.CreateCategoryUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.category.request.CategoryRequest;

@RestController
@RequestMapping("/categories")
public class CreateCategoryController {
    private final CreateCategoryUseCase createCategoryUseCase;

    public CreateCategoryController(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CategoryRequest categoryRequest, UriComponentsBuilder ucb) {
        var category = createCategoryUseCase.execute(categoryRequest.toCategory());
        URI uri = ucb.path("/categories/{id}").buildAndExpand(category.id()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
