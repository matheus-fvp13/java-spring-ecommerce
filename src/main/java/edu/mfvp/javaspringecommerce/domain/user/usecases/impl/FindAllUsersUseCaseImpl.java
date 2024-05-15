package edu.mfvp.javaspringecommerce.domain.user.usecases.impl;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.FindAllUsersUseCase;

import java.util.List;

public class FindAllUsersUseCaseImpl implements FindAllUsersUseCase {
    private final UserRepositoryGateway userRepositoryGateway;

    public FindAllUsersUseCaseImpl(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public List<User> execute() {
        return userRepositoryGateway.findAll();
    }
}
