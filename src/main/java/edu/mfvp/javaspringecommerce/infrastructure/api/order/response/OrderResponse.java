package edu.mfvp.javaspringecommerce.infrastructure.api.order.response;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;
import edu.mfvp.javaspringecommerce.domain.order.entities.enums.OrderStatus;
import edu.mfvp.javaspringecommerce.infrastructure.api.order_item.response.OrderItemResponse;
import edu.mfvp.javaspringecommerce.infrastructure.api.payment.response.PaymentResponse;

public record OrderResponse(
    Long id,
    Instant moment,
    String clientName,
    String clientEmail,
    OrderStatus orderStatus,
    Optional<PaymentResponse> payment,
    Set<OrderItemResponse> items
) {

    public static OrderResponse fromDomain(Order order) {
        var items = order.items().stream()
            .map(OrderItemResponse::fromDomain)
            .collect(Collectors.toSet());
            
        return new OrderResponse(
            order.id(),
            order.moment(),
            order.client().getName(),
            order.client().getEmail(),
            order.orderStatus(),
            PaymentResponse.fromDomain(order.payment()),
            items
        );
    }

}
