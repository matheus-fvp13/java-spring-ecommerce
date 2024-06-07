package edu.mfvp.javaspringecommerce.infrastructure.api.category.response;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;

public record CategoryResponse(
    Long id,
    String name
) {
    public static CategoryResponse fromDomain(Category category) {
        return new CategoryResponse(category.id(), category.name());
    }
}
