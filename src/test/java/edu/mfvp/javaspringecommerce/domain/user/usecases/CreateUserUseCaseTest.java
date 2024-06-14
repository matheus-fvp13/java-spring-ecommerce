package edu.mfvp.javaspringecommerce.domain.user.usecases;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.exceptions.UserEmailAlreadyExistsException;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.CreateUserUseCaseImpl;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCase;

    @Mock
    private UserRepositoryGateway userRepositoryGateway;

    @Test
    public void shouldBeAbleToCreateAUserIfEmailNotExists() {
        var user = Instancio.create(User.class);
        when(userRepositoryGateway.create(user)).thenReturn(user);
        when(userRepositoryGateway.existsByEmail(user.email())).thenReturn(false);

        var userCreated = createUserUseCase.execute(user);

        assertEquals(user, userCreated);
        verify(userRepositoryGateway).existsByEmail(user.email());
        verify(userRepositoryGateway).create(user);
        verifyNoMoreInteractions(userRepositoryGateway);
    }

    @Test
    public void shouldNotBeAbleToCreateAUserIfEmailAlreadyExists() {
        var user = Instancio.create(User.class);
        when(userRepositoryGateway.existsByEmail(user.email())).thenReturn(true);

        assertThrows(UserEmailAlreadyExistsException.class, () -> createUserUseCase.execute(user));

        verify(userRepositoryGateway).existsByEmail(user.email());
        verifyNoMoreInteractions(userRepositoryGateway);
    }
}
