package edu.mfvp.javaspringecommerce.domain.order.usecases.impl;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;
import edu.mfvp.javaspringecommerce.domain.order.gateways.OrderRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.order.usecases.FindAllOrdersUseCase;

public class FindAllOrdersUseCaseImpl implements FindAllOrdersUseCase {
    private final OrderRepositoryGateway orderRepositoryGateway;

    public FindAllOrdersUseCaseImpl(OrderRepositoryGateway orderRepositoryGateway) {
        this.orderRepositoryGateway = orderRepositoryGateway;
    }

    @Override
    public List<Order> execute() {
        return orderRepositoryGateway.findAll();
    }

}
