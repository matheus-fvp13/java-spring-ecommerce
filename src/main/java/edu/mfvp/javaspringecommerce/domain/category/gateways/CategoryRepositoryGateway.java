package edu.mfvp.javaspringecommerce.domain.category.gateways;


import java.util.List;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;

public interface CategoryRepositoryGateway {
    Category create(Category category);
    boolean existsByName(String name);
    List<Category> findAll();
}
