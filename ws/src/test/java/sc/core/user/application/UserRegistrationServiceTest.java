package sc.core.user.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sc.adapter.persistence.user.UserPersistenceAdapter;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.application.service.UserRegistrationService;
import sc.core.user.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserRegistrationServiceTest {

    private RegisterUserUseCase registerUserUseCase;

    @Mock
    private UserPersistenceAdapter userPersistenceAdapter;

    @BeforeEach
    void initUseCase() {
        registerUserUseCase = new UserRegistrationService(userPersistenceAdapter);
    }

    @Test
    void exampleTest() {
        final String username = "example";

        User savedUsername = registerUserUseCase.registerUser(new User());

        assertEquals(savedUsername, username);
    }

}