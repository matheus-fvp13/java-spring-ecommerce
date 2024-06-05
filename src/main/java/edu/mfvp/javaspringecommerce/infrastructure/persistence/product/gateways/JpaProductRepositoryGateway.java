package edu.mfvp.javaspringecommerce.infrastructure.persistence.product.gateways;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.product.entities.Product;
import edu.mfvp.javaspringecommerce.domain.product.gateways.ProductRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.mapper.ProductMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.repositories.JpaProductRepository;

public class JpaProductRepositoryGateway implements ProductRepositoryGateway {
    private final JpaProductRepository jpaProductRepository;

    public JpaProductRepositoryGateway(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
            .map(ProductMapper::toProduct)
            .toList();
    }

}
