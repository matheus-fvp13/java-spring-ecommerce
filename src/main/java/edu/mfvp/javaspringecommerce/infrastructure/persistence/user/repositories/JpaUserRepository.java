package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.repositories;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserDetails> findByEmail(String email);
    boolean existsByEmail(String email);
}
