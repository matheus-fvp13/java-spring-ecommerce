package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.gateways;

import java.util.List;
import java.util.Optional;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper.UserMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.repositories.JpaUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JpaUserRepositoryGateway implements UserRepositoryGateway {
    private final JpaUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public JpaUserRepositoryGateway(JpaUserRepository repository,
                                    PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        var userEntity = UserMapper.toUserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.password()));

        return UserMapper.toUser(repository.save(userEntity));
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        var optionalUser = repository.findById(id);
        return optionalUser.map(UserMapper::toUser);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll()
                .stream()
                .map(UserMapper::toUser)
                .toList();
    }

}
