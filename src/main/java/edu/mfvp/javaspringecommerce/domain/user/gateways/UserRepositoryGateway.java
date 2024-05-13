package edu.mfvp.javaspringecommerce.domain.user.gateways;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

public interface UserRepositoryGateway {

    User create(User user);
    boolean existsByEmail(String email);

}
