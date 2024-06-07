package edu.mfvp.javaspringecommerce.infrastructure.api.payment.response;

import java.time.Instant;
import java.util.Optional;

import edu.mfvp.javaspringecommerce.domain.payment.entities.Payment;

public record PaymentResponse(
    Long id,
    Instant moment
) {
    public static Optional<PaymentResponse> fromDomain(Optional<Payment> payment) {
        if(payment.isEmpty()) return Optional.empty();
        var paymentResponse = payment.get();
        return Optional.of(new PaymentResponse(paymentResponse.id(), paymentResponse.moment()));
    }
}
