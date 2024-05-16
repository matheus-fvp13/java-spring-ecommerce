package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;

public class UserMapper {
    public static User toUser(UserEntity userEntity) {
        var user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setPhone(userEntity.getPhone());
        user.setPassword(userEntity.getPassword());
        return user;
    }

    public static UserEntity toUserEntity(User user) {
        var userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }
}
