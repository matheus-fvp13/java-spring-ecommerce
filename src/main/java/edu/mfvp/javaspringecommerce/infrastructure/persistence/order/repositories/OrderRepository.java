package edu.mfvp.javaspringecommerce.infrastructure.persistence.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.order.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
