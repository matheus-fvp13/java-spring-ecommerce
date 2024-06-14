package edu.mfvp.javaspringecommerce.infrastructure.persistence.role.mapper;

import edu.mfvp.javaspringecommerce.domain.role.entities.Role;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.role.entities.RoleEntity;

public class RoleMapper {
    public static Role toRole(RoleEntity roleEntity) {
        return new Role(
                roleEntity.getId(),
                roleEntity.getName()
        );
    }

    public static RoleEntity toRoleEntity(Role role) {
        var roleEntity = new RoleEntity();
        roleEntity.setId(role.id());
        roleEntity.setName(role.name());
        return roleEntity;
    }
}
