package edu.mfvp.javaspringecommerce.domain.order.entities;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

import java.time.Instant;
import java.util.Objects;

public class Order {

    private Long id;
    private Instant moment;
    private User client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
