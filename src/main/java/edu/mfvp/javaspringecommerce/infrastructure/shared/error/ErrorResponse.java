package edu.mfvp.javaspringecommerce.infrastructure.shared.error;

import java.time.Instant;

public record ErrorResponse(
        int statusCode,
        Instant timestamp,
        String message
) {
}
