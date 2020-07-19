package sc.core.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sc.adapter.persistence.user.UserPersistenceAdapter;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.application.service.UserRegistrationService;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterUserUseCaseUnitTest {

    private RegisterUserUseCase registerUserUseCase;

    @Mock
    private UserPersistenceAdapter userPersistenceAdapter;

    @BeforeEach
    void initUseCase() {
        registerUserUseCase = new UserRegistrationService(userPersistenceAdapter);
    }

    @Test
    void saveFullUserWithoutValidation() {
        User userToSave = new User()
                .setId(1L)
                .setEmail("test@email.com")
                .setPhone("+37525222222")
                .setPassword("password")
                .setRoles(new HashSet<>(Collections.singletonList(new Role())));

        when(userPersistenceAdapter.saveUser(userToSave))
                .thenReturn(new User()
                        .setId(userToSave.getId())
                        .setEmail(userToSave.getEmail())
                        .setPhone(userToSave.getPhone())
                        .setPassword(userToSave.getPassword())
                        .setRoles(userToSave.getRoles()));

        User savedUser = registerUserUseCase.registerUser(userToSave);

        assertEquals(userToSave, savedUser);
    }

}