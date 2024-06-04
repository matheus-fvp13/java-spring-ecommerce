package edu.mfvp.javaspringecommerce.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.mfvp.javaspringecommerce.domain.order.gateways.OrderRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.order.usecases.FindAllOrdersUseCase;
import edu.mfvp.javaspringecommerce.domain.order.usecases.impl.FindAllOrdersUseCaseImpl;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.gateway.JpaOrderRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.repositories.OrderRepository;

@Configuration
public class OrderConfig {
    @Bean
    FindAllOrdersUseCase getFindAllOrdersUseCase(OrderRepositoryGateway gateway) {
        return new FindAllOrdersUseCaseImpl(gateway);
    }

    @Bean
    OrderRepositoryGateway getOrderRepositoryGateway(OrderRepository repository) {
        return new JpaOrderRepositoryGateway(repository);
    }
}
