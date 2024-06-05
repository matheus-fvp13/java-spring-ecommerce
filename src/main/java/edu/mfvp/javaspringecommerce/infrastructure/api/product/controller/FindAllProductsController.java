package edu.mfvp.javaspringecommerce.infrastructure.api.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mfvp.javaspringecommerce.domain.product.usecases.FindAllProductsUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.product.response.ProductResponse;

@RestController
@RequestMapping("api/v1/products")
public class FindAllProductsController {
    private final FindAllProductsUseCase findAllProductsUseCase;

    public FindAllProductsController(FindAllProductsUseCase findAllProductsUseCase) {
        this.findAllProductsUseCase = findAllProductsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        var productsResponse = findAllProductsUseCase.execute()
            .stream()
            .map(ProductResponse::fromDomain)
            .toList();
        return ResponseEntity.ok(productsResponse);
    }

}
