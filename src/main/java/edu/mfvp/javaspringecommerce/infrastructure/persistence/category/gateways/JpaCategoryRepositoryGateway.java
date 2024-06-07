package edu.mfvp.javaspringecommerce.infrastructure.persistence.category.gateways;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.domain.category.gateways.CategoryRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers.CategoryMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.repositories.JpaCategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaCategoryRepositoryGateway implements CategoryRepositoryGateway {
    private final JpaCategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        var categoryEntity = categoryRepository.save(CategoryMapper.toCategoryEntity(category)); 
        return CategoryMapper.toCategory(categoryEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategory)
                .toList();
    }

}
