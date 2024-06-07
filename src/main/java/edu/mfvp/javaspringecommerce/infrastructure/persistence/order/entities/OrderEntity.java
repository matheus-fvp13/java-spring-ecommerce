package edu.mfvp.javaspringecommerce.infrastructure.persistence.order.entities;

import edu.mfvp.javaspringecommerce.domain.order.entities.enums.OrderStatus;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.order_item.entities.OrderItemEntity;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.payment.entities.PaymentEntity;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AccessLevel;

@Setter
@Getter
@Entity(name = "orders")
public class OrderEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentEntity payment;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItemEntity> items = new HashSet<>();

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
