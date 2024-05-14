package edu.mfvp.javaspringecommerce.domain.user.usecases.impl;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.exceptions.UserNotFoundException;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.FindUserByIdUseCase;

public class FindUserByIdUseCaseImpl implements FindUserByIdUseCase{
    private final UserRepositoryGateway userRepositoryGateway;

    public FindUserByIdUseCaseImpl(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public User execute(Long id) {
        return userRepositoryGateway.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
    }

}
