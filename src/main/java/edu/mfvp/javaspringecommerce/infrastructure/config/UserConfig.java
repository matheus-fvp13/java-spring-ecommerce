package edu.mfvp.javaspringecommerce.infrastructure.config;

import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.FindAllUsersUseCase;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.FindAllUsersUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    FindAllUsersUseCase getFindAllUsersUseCase(UserRepositoryGateway gateway) {
        return new FindAllUsersUseCaseImpl(gateway);
    }
}
