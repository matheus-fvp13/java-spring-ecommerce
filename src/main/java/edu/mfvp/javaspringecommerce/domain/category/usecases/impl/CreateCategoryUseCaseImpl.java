package edu.mfvp.javaspringecommerce.domain.category.usecases.impl;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.domain.category.exceptions.CategoryNameAlreadyExistsException;
import edu.mfvp.javaspringecommerce.domain.category.gateways.CategoryRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.category.usecases.CreateCategoryUseCase;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
    private final CategoryRepositoryGateway categoryRepositoryGateway;

    public CreateCategoryUseCaseImpl(CategoryRepositoryGateway categoryRepositoryGateway) {
        this.categoryRepositoryGateway = categoryRepositoryGateway;
    }

    @Override
    public Category execute(Category category) {
        if(categoryRepositoryGateway.existsByName(category.getName())) 
            throw new CategoryNameAlreadyExistsException(category.getName());
        return categoryRepositoryGateway.create(category);
    }

}
