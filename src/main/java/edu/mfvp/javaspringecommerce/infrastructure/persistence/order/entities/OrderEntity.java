package edu.mfvp.javaspringecommerce.infrastructure.persistence.order.entities;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;

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
