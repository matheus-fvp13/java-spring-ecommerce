package edu.mfvp.javaspringecommerce.infrastructure.config;

import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.CreateUserUseCase;
import edu.mfvp.javaspringecommerce.domain.user.usecases.FindAllUsersUseCase;
import edu.mfvp.javaspringecommerce.domain.user.usecases.FindUserByIdUseCase;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.CreateUserUseCaseImpl;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.FindAllUsersUseCaseImpl;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.FindUserByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    FindAllUsersUseCase getFindAllUsersUseCase(UserRepositoryGateway gateway) {
        return new FindAllUsersUseCaseImpl(gateway);
    }

    @Bean
    FindUserByIdUseCase getFindUserByIdUseCase(UserRepositoryGateway gateway) {
        return new FindUserByIdUseCaseImpl(gateway);
    }

    @Bean
    CreateUserUseCase getCreateUserUseCase(UserRepositoryGateway gateway) {
        return new CreateUserUseCaseImpl(gateway);
    }

}
