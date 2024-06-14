package edu.mfvp.javaspringecommerce.infrastructure.api.user.response;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

public record UserResponse(
    Long id,
    String name,
    String email,
    String phone
) {

    public static UserResponse fromEntity(User user) {
        return new UserResponse(user.id(), user.name(),
                user.email(), user.phone());
    }

}
