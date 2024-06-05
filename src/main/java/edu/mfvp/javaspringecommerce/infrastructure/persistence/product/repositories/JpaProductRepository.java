package edu.mfvp.javaspringecommerce.infrastructure.persistence.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.entities.ProductEntity;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

}
