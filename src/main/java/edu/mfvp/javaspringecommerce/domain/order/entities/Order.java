package edu.mfvp.javaspringecommerce.domain.order.entities;

import edu.mfvp.javaspringecommerce.domain.order.entities.enums.OrderStatus;
import edu.mfvp.javaspringecommerce.domain.order_item.entities.OrderItem;
import edu.mfvp.javaspringecommerce.domain.user.entities.User;

import java.time.Instant;
import java.util.Set;

public record Order(
    Long id,
    Instant moment,
    OrderStatus orderStatus,
    User client,
    Set<OrderItem> items
) {
}
