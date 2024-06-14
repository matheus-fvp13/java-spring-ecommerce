package edu.mfvp.javaspringecommerce.infrastructure.api.auth.request;

import edu.mfvp.javaspringecommerce.domain.role.entities.Role;
import edu.mfvp.javaspringecommerce.domain.user.entities.User;

import java.util.Set;

public record SignUpRequest(
        String email,
        String password,
        String name,
        String phone,
        Set<Role> roles
) {
    public User toDomain() {
        return new User(
                null,
                name,
                email,
                phone,
                password,
                roles
        );
    }
}
