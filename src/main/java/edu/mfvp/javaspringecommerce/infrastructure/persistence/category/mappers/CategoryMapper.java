package edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.entities.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toCategoryEntity(Category category) {
        var entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        return entity;
    }

    public static Category toCategory(CategoryEntity categoryEntity) {
        var category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    } 
    
}
