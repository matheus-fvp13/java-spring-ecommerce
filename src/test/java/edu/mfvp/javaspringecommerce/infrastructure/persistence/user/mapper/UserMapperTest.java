package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;

public class UserMapperTest {

    @Test
    public void shouldMapUserEntityToUser() {
        var expectedUser = Instancio.create(User.class);
        var userEntity = new UserEntity();
        userEntity.setEmail(expectedUser.getEmail());
        userEntity.setPassword(expectedUser.getPassword());
        userEntity.setName(expectedUser.getName());
        userEntity.setId(expectedUser.getId());
        userEntity.setPhone(expectedUser.getPhone());
        
        var result = UserMapper.toUser(userEntity);

        Assertions.assertEquals(expectedUser, result);
    }

    @Test
    public void shouldMapUserToUserEntity() {
        var expectedUser = Instancio.create(User.class);

        var result = UserMapper.toUserEntity(expectedUser);

        Assertions.assertEquals(expectedUser.getEmail(), result.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(), result.getPassword());
        Assertions.assertEquals(expectedUser.getName(), result.getName());
        Assertions.assertEquals(expectedUser.getPhone(), result.getPhone());
    }

}
