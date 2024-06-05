package edu.mfvp.javaspringecommerce.domain.product.usecases;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.product.entities.Product;

public interface FindAllProductsUseCase {
    List<Product> execute();
}
