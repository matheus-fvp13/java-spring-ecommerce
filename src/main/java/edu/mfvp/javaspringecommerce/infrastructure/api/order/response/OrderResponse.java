package edu.mfvp.javaspringecommerce.infrastructure.api.order.response;

import java.time.Instant;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;
import edu.mfvp.javaspringecommerce.domain.order.entities.enums.OrderStatus;

public record OrderResponse(
    Long id,
    Instant moment,
    String clientName,
    String clientEmail,
    OrderStatus orderStatus 
) {

    public static OrderResponse fromDomain(Order order) {
        return new OrderResponse(
            order.getId(),
            order.getMoment(),
            order.getClient().getName(),
            order.getClient().getEmail(),
            order.getOrderStatus()
        );
    }

}
