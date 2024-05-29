package edu.mfvp.javaspringecommerce.infrastructure.api.category.request;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;

public record CategoryRequest(
    String name
) {
    public Category toCategory() {
        var category = new Category();
        category.setName(name());
        return category;
    }
}
