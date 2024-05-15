package edu.mfvp.javaspringecommerce.domain.user.usecases;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.FindAllUsersUseCaseImpl;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindAllUsersUseCaseTest {
    @InjectMocks
    private FindAllUsersUseCaseImpl findAllUsersUseCase;

    @Mock
    private UserRepositoryGateway userRepositoryGateway;

    @Test
    public void shouldBeAbleToFindAllUsers() {
        var users = Instancio.stream(User.class).limit(10).toList();
        when(userRepositoryGateway.findAll()).thenReturn(users);

        var result = findAllUsersUseCase.execute();

        assertEquals(users.size(), result.size());
        assertEquals(users, result);
        verify(userRepositoryGateway).findAll();
        verifyNoMoreInteractions(userRepositoryGateway);
    }
}
