package edu.mfvp.javaspringecommerce.domain.order.usecases;

import java.util.List;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;

public interface FindAllOrdersUseCase {
    List<Order> execute();
}
