package edu.mfvp.javaspringecommerce.domain.user.gateways;

import edu.mfvp.javaspringecommerce.domain.user.entities.User;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class UserRepositoryGatewayTest {
    public abstract UserRepositoryGateway getUserRepositoryGateway();

    @Test
    public void shouldBeAbleToPersistUser() {
        var user = Instancio.create(User.class);

        var result = getUserRepositoryGateway().create(user);

        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getPhone(), result.getPhone());
    }
}
