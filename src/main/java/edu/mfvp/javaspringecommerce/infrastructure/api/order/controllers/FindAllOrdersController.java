package edu.mfvp.javaspringecommerce.infrastructure.api.order.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mfvp.javaspringecommerce.domain.order.usecases.FindAllOrdersUseCase;
import edu.mfvp.javaspringecommerce.infrastructure.api.order.response.OrderResponse;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/orders")
public class FindAllOrdersController {
    private final FindAllOrdersUseCase findAllOrdersUseCase;

    public FindAllOrdersController(FindAllOrdersUseCase findAllOrdersUseCase) {
        this.findAllOrdersUseCase = findAllOrdersUseCase;
    }   

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        var orderResponses = findAllOrdersUseCase.execute().stream()
            .map(OrderResponse::fromDomain)
            .toList();
        return ResponseEntity.ok().body(orderResponses);
    }

}
