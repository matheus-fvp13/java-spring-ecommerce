package edu.mfvp.javaspringecommerce.domain.order.gateways;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;

public interface OrderRepositoryGateway {
    List<Order> findAll();
}
