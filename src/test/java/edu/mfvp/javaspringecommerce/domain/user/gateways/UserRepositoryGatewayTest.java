package edu.mfvp.javaspringecommerce.domain.user.gateways;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper.UserMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public abstract class UserRepositoryGatewayTest {
    public abstract UserRepositoryGateway getUserRepositoryGateway();

    @Test
    public void shouldBeAbleToPersistUser() {
        var user = Instancio.create(User.class);

        var result = getUserRepositoryGateway().create(user);

        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getPhone(), result.getPhone());
    }

    @Test
    public void shouldFindUserByIdIfExists() {
        var user = Instancio.create(User.class);
        user.setId(null);
        var savedUser = getUserRepositoryGateway().create(user);

        var result = getUserRepositoryGateway().findById(savedUser.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(savedUser.getId(), result.get().getId());
    }

    @Test
    public void shouldNotFindUserByIdIfNotExists() {
        var user = Instancio.create(User.class);

        var result = getUserRepositoryGateway().findById(user.getId());

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void shouldFindAllUsers() {
        var userList = Instancio.stream(User.class).limit(5).toList();
        var userSchemaList = userList.stream().map(UserMapper::toUserEntity).toList();
        userSchemaList.forEach(u -> u.setId(null));

        //getUserRepositoryGateway().create();
    }
}
