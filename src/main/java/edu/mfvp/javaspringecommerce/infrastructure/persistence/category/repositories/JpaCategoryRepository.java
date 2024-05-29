package edu.mfvp.javaspringecommerce.infrastructure.persistence.category.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.entities.CategoryEntity;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
}
