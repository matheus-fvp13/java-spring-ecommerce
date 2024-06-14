package edu.mfvp.javaspringecommerce.domain.user.entities;

import edu.mfvp.javaspringecommerce.domain.role.entities.Role;

import java.util.Set;

public record User(
        Long id,
        String name,
        String email,
        String phone,
        String password,
        Set<Role> roles
) {
}
