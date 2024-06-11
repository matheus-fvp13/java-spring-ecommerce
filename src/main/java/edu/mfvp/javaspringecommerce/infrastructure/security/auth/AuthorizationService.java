package edu.mfvp.javaspringecommerce.infrastructure.security.auth;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.user.repositories.JpaUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthorizationService implements UserDetailsService {
    private final JpaUserRepository repository;

    public AuthorizationService(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
    }

}
