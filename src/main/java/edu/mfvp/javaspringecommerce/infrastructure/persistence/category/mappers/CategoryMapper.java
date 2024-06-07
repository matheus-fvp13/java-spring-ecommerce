package edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers;

import edu.mfvp.javaspringecommerce.domain.category.entities.Category;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.entities.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toCategoryEntity(Category category) {
        var entity = new CategoryEntity();
        entity.setId(category.id());
        entity.setName(category.name());
        return entity;
    }

    public static Category toCategory(CategoryEntity categoryEntity) {
        return new Category(
            categoryEntity.getId(),
            categoryEntity.getName()
        );
    } 
    
}
