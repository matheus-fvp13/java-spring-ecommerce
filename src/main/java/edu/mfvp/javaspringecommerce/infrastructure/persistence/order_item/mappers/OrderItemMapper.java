package edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.mappers;

import edu.mfvp.javaspringecommerce.domain.order_item.entities.OrderItem;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.entities.OrderItemEntity;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.product.mapper.ProductMapper;

public class OrderItemMapper {
    public static OrderItem toOrderItem(OrderItemEntity orderItemEntity) {
        return new OrderItem(
            ProductMapper.toProduct(orderItemEntity.getProduct()),
            orderItemEntity.getQuantity(),
            orderItemEntity.getPrice()
        );
    }
}
