package edu.mfvp.javaspringecommerce.infrastructure.persistence.order.mapper;

import edu.mfvp.javaspringecommerce.domain.order.entities.Order;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.entities.OrderEntity;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper.UserMapper;

public class OrderMapper {
    public static Order toOrder(OrderEntity orderEntity) {
        var order = new Order();
        order.setId(orderEntity.getId());
        order.setMoment(orderEntity.getMoment());
        order.setClient(UserMapper.toUser(orderEntity.getClient()));

        return order;
    }
}
