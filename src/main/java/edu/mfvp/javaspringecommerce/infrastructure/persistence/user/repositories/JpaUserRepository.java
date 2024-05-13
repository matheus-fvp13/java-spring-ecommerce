package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.repositories;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
