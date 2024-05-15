package edu.mfvp.javaspringecommerce.domain.user.gateways;

import java.util.List;
import java.util.Optional;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

public interface UserRepositoryGateway {

    User create(User user);
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);
    List<User> findAll();

}
