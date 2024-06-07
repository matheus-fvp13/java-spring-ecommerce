package edu.mfvp.javaspringecommerce.infrastructure.api.category.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mfvp.javaspringecommerce.domain.category.usecases.FindAllCategoriesUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.category.response.CategoryResponse;

@RestController
@RequestMapping("/categories")
public class FindAllCategoriesController {
    private final FindAllCategoriesUseCase findAllCategoriesUseCase;

    public FindAllCategoriesController(FindAllCategoriesUseCase findAllCategoriesUseCase) {
        this.findAllCategoriesUseCase = findAllCategoriesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        var categoriesResponse = findAllCategoriesUseCase.execute()
            .stream()
            .map(CategoryResponse::fromDomain)
            .toList();
        return ResponseEntity.ok().body(categoriesResponse);
    }

}
