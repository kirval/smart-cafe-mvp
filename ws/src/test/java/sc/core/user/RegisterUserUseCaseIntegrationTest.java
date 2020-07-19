package sc.core.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RegisterUserUseCaseIntegrationTest {

    @Autowired
    private RegisterUserUseCase registerUserUseCase;

    @Test
    void saveUserWithInvalidEmailThrowsException() {
        User userWithInvalidEmail = new User()
                .setId(1L)
                .setEmail("invalidemail")
                .setPassword("")
                .setRoles(new HashSet<>(Collections.singletonList(new Role())));

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithInvalidEmail));
    }

}