package edu.mfvp.javaspringecommerce.infrastructure.api.product.response;

import java.util.Set;
import java.util.stream.Collectors;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.domain.product.entities.Product;

public record ProductResponse(
    Long id,
    String name,
    String description,
    Double price,
    String imgUrl,
    Set<String> categories
) {
    public static ProductResponse fromDomain(Product product) {
        var categories = product.categories()
            .stream()
            .map(Category::name)
            .collect(Collectors.toSet());

        return new ProductResponse(
            product.id(),
            product.name(),
            product.description(),
            product.price(),
            product.imgUrl(),
            categories
        );
    }
}
