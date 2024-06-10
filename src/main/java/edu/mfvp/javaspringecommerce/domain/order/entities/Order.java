package edu.mfvp.javaspringecommerce.domain.order.entities;

import edu.mfvp.javaspringecommerce.domain.order.entities.enums.OrderStatus;
import edu.mfvp.javaspringecommerce.domain.order_item.entities.OrderItem;
import edu.mfvp.javaspringecommerce.domain.payment.entities.Payment;
import edu.mfvp.javaspringecommerce.domain.user.entities.User;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

public record Order(
    Long id,
    Instant moment,
    OrderStatus orderStatus,
    User client,
    Optional<Payment> payment,
    Set<OrderItem> items
) {

    public Double getTotal() {
        return items.stream()
            .mapToDouble(OrderItem::getSubTotal)
            .sum();
    }
}
