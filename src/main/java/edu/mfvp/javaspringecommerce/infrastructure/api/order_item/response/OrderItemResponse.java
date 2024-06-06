package edu.mfvp.javaspringecommerce.infrastructure.api.order_item.response;

import edu.mfvp.javaspringecommerce.domain.order_item.entities.OrderItem;

public record OrderItemResponse(
    Long productId,
    String productName,
    Integer quantity,
    Double price
) {

    public static OrderItemResponse fromDomain(OrderItem orderItem) {
        return new OrderItemResponse(
            orderItem.product().id(),
            orderItem.product().name(),
            orderItem.quantity(),
            orderItem.price()
        );
    }

}
