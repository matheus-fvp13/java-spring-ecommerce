package edu.mfvp.javaspringecommerce.domain.category.usecases;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;

public interface FindAllCategoriesUseCase {
    List<Category> execute();
}
