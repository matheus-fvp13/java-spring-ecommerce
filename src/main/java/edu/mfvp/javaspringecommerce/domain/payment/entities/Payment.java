package edu.mfvp.javaspringecommerce.domain.payment.entities;

import java.time.Instant;

public record Payment(
    Long id,
    Instant moment
) {
}
