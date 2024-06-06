package edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.entities.OrderItemEntity;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.entities.pk.OrderItemPK;

@Repository
public interface JpaOrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPK> {

}
