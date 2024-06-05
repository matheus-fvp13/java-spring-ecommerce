package edu.mfvp.javaspringecommerce.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.mfvp.javaspringecommerce.domain.product.gateways.ProductRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.product.usecases.FindAllProductsUseCase;
import edu.mfvp.javaspringecommerce.domain.product.usecases.impl.FindAllProductsUseCaseImpl;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.gateways.JpaProductRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.repositories.JpaProductRepository;

@Configuration
public class ProductConfig {
    @Bean
    FindAllProductsUseCase getFindAllProductsUseCase(ProductRepositoryGateway gateway) {
        return new FindAllProductsUseCaseImpl(gateway);
    }

    @Bean
    ProductRepositoryGateway getProductRepositoryGateway(JpaProductRepository repository) {
        return new JpaProductRepositoryGateway(repository);
    }
}
