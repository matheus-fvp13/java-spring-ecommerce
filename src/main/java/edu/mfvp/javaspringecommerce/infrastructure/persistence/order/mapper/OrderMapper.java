package edu.mfvp.javaspringecommerce.infrastructure.persistence.order.mapper;

import java.util.stream.Collectors;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.entities.OrderEntity;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.mappers.OrderItemMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper.UserMapper;

public class OrderMapper {
    public static Order toOrder(OrderEntity orderEntity) {
        var items = orderEntity.getItems()
            .stream()
            .map(OrderItemMapper::toOrderItem)
            .collect(Collectors.toSet());
        return new Order(
            orderEntity.getId(),
            orderEntity.getMoment(),
            orderEntity.getOrderStatus(),
            UserMapper.toUser(orderEntity.getClient()),
            items
        );
    }
}
