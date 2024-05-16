package edu.mfvp.javaspringecommerce.infrastructure.persistence.user.gateways;

import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.user.gateways.UserRepositoryGatewayTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaUserRepositoryGatewayTest extends UserRepositoryGatewayTest {
    @Autowired
    private JpaUserRepositoryGateway userRepositoryGateway;

    @Override
    public UserRepositoryGateway getUserRepositoryGateway() {
        return userRepositoryGateway;
    }

}
