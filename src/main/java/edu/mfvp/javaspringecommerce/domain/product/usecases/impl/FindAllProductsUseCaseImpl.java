package edu.mfvp.javaspringecommerce.domain.product.usecases.impl;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.product.entities.Product;
import edu.mfvp.javaspringecommerce.domain.product.gateways.ProductRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.product.usecases.FindAllProductsUseCase;

public class FindAllProductsUseCaseImpl implements FindAllProductsUseCase {
    private final ProductRepositoryGateway productRepositoryGateway;

    public FindAllProductsUseCaseImpl(ProductRepositoryGateway productRepositoryGateway) {
        this.productRepositoryGateway = productRepositoryGateway;
    }

    @Override
    public List<Product> execute() {
        return productRepositoryGateway.findAll();
    }

}
