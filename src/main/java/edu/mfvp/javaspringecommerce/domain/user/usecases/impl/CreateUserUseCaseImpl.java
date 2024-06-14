package edu.mfvp.javaspringecommerce.domain.user.usecases.impl;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.exceptions.UserEmailAlreadyExistsException;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.CreateUserUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepositoryGateway userRepositoryGateway;

    public CreateUserUseCaseImpl(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public User execute(User user) {
        if(userRepositoryGateway.existsByEmail(user.email())) {
            throw new UserEmailAlreadyExistsException(user.email());
        }
        return userRepositoryGateway.create(user);
    }
}
