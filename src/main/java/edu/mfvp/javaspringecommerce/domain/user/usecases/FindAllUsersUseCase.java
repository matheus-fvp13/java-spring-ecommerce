package edu.mfvp.javaspringecommerce.domain.user.usecases;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

import java.util.List;

public interface FindAllUsersUseCase {
    List<User> execute();
}
