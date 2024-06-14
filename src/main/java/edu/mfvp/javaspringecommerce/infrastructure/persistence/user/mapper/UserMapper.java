package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.role.mapper.RoleMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    public static User toUser(UserEntity userEntity) {
        var roles = userEntity.getRoles()
                .stream()
                .map(RoleMapper::toRole)
                .collect(Collectors.toSet());
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getPassword(),
                roles
        );
    }

    public static UserEntity toUserEntity(User user) {
        var userEntity = new UserEntity();
        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        userEntity.setPhone(user.phone());
        userEntity.setPassword(user.password());

        for (var role : user.roles()) {
            userEntity.getRoles().add(RoleMapper.toRoleEntity(role));
        }

        return userEntity;
    }
}
