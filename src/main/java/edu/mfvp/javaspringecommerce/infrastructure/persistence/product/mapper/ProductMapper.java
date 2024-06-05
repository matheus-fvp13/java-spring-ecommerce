package edu.mfvp.javaspringecommerce.infrastructure.persistence.product.mapper;

import java.util.stream.Collectors;

import edu.mfvp.javaspringecommerce.domain.product.entities.Product;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers.CategoryMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.entities.ProductEntity;

public class ProductMapper {
    public static Product toProduct(ProductEntity productEntity) {
        var categories = productEntity.getCategories()
            .stream()
            .map(CategoryMapper::toCategory)
            .collect(Collectors.toSet());

        return new Product(productEntity.getId(), 
            productEntity.getName(), 
            productEntity.getDescription(), 
            productEntity.getPrice(), 
            productEntity.getImgUrl(), 
            categories);
    }
}
