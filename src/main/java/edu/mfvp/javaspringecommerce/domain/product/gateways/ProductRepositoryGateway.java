package edu.mfvp.javaspringecommerce.domain.product.gateways;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.product.entities.Product;

public interface ProductRepositoryGateway {
    List<Product> findAll();
}
