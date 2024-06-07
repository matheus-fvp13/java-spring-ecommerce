package edu.mfvp.javaspringecommerce.domain.category.usecases.impl;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.domain.category.gateways.CategoryRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.category.usecases.FindAllCategoriesUseCase;

public class FindAllCategoryUseCaseImpl implements FindAllCategoriesUseCase {
    private final CategoryRepositoryGateway categoryRepositoryGateway;

    public FindAllCategoryUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway) {
        this.categoryRepositoryGateway = categoryRepositoryGateway;
    }

    @Override
    public List<Category> execute() {
        return categoryRepositoryGateway.findAll();
    }

}
