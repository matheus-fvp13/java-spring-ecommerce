package edu.mfvp.javaspringecommerce.domain.category.usecases;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;

public interface CreateCategoryUseCase {
    Category execute(Category category);
}
