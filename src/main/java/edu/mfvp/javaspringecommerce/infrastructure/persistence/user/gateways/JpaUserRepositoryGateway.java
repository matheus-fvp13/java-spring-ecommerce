package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.gateways;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

}
