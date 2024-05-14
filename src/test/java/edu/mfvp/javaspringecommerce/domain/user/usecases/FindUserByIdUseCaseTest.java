package edu.mfvp.javaspringecommerce.domain.user.usecases;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.exceptions.UserNotFoundException;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.usecases.impl.FindUserByIdUseCaseImpl;

@ExtendWith(MockitoExtension.class)
public class FindUserByIdUseCaseTest {
    
    @InjectMocks
    private FindUserByIdUseCaseImpl findUserByIdUseCase;

    @Mock
    private UserRepositoryGateway userRepositoryGateway;
    
    @Test
    public void shouldBeAbleToFindUserById() {
        var user = Instancio.create(User.class);
        when(userRepositoryGateway.findById(user.getId())).thenReturn(Optional.of(user));

        var result = findUserByIdUseCase.execute(user.getId());

        Assertions.assertEquals(user, result);
        verify(userRepositoryGateway).findById(user.getId());
        verifyNoMoreInteractions(userRepositoryGateway);
    }

    @Test
    public void shouldNotBeAbleToFindUserIfIdNotExists() {
        var user = Instancio.create(User.class);
        when(userRepositoryGateway.findById(user.getId())).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class, () -> findUserByIdUseCase.execute(user.getId()));
        Assertions.assertEquals("User with id " + user.getId() + " was not found.", Assertions.assertThrows(UserNotFoundException.class, () -> findUserByIdUseCase.execute(user.getId())).getMessage());

        verify(userRepositoryGateway, times(2)).findById(user.getId());
        verifyNoMoreInteractions(userRepositoryGateway);
    }

}
