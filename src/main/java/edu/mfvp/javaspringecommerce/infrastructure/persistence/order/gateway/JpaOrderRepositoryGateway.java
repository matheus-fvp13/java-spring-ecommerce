package edu.mfvp.javaspringecommerce.infrastructure.persistence.order.gateway;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;
import edu.mfvp.javaspringecommerce.domain.order.gateways.OrderRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.mapper.OrderMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.repositories.OrderRepository;

public class JpaOrderRepositoryGateway implements OrderRepositoryGateway {
    private final OrderRepository orderRepository;

    public JpaOrderRepositoryGateway(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll().stream()
            .map(OrderMapper::toOrder)
            .toList();
    }

}
