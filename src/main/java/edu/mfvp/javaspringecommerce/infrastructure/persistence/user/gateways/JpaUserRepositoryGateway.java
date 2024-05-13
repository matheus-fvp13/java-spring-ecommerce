package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.gateways;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;

public class JpaUserRepositoryGateway implements UserRepositoryGateway {

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}
