package edu.mfvp.javaspringecommerce.infrastructure.persistence.category.gateways;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.domain.category.gateways.CategoryRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers.CategoryMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.repositories.JpaCategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaCategoryRepositoryGateway implements CategoryRepositoryGateway {
    private final CategoryMapper categoryMapper;
    private final JpaCategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        var categoryEntity = categoryRepository.save(categoryMapper.convertToCategoryEntity(category)); 
        return categoryMapper.convertToCategory(categoryEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

}
