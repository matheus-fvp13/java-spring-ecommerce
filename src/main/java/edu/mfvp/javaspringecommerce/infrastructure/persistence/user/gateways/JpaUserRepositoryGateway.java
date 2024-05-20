package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.gateways;

import java.util.List;
import java.util.Optional;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.mapper.UserMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.repositories.JpaUserRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaUserRepositoryGateway implements UserRepositoryGateway {
    private final JpaUserRepository repository;

    public JpaUserRepositoryGateway(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        var userEntity = repository.save(UserMapper.toUserEntity(user));
        return UserMapper.toUser(userEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
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
