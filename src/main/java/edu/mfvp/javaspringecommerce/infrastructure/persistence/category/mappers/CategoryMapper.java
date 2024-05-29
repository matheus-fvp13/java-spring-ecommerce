package edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.entities.CategoryEntity;

public class CategoryMapper {
    private final ModelMapper modelMapper;
    
    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryEntity convertToCategoryEntity(Category category) {
        return modelMapper.map(category, CategoryEntity.class);
    }

    public Category convertToCategory(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, Category.class);
    } 
}
