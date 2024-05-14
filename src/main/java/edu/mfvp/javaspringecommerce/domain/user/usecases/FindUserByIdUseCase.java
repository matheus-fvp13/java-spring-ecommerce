package edu.mfvp.javaspringecommerce.domain.user.usecases;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;

public interface FindUserByIdUseCase {
    User execute(Long id);
}
