package edu.mfvp.javaspringecommerce.domain.product.entities;

import java.util.Set;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;

public record Product(
    Long id,
    String name,
    String description,
    Double price,
    String imgUrl,
    Set<Category> categories
) {
}
