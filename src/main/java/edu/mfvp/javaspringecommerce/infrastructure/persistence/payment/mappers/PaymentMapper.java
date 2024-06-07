package edu.mfvp.javaspringecommerce.infrastructure.persistence.payment.mappers;

import java.util.Optional;

import edu.mfvp.javaspringecommerce.domain.payment.entities.Payment;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.payment.entities.PaymentEntity;

public class PaymentMapper {
    public static Optional<Payment> toPayment(PaymentEntity paymentEntity) {
        if(paymentEntity != null) {
            var payment = new Payment(
                paymentEntity.getId(), 
                paymentEntity.getMoment()
            );
            return Optional.of(payment);
        }
        
        return Optional.empty();
    }

}
