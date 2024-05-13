package edu.mfvp.javaspringecommerce.domain.user.usecases;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

public interface CreateUserUseCase {
    User execute(User user);
}
