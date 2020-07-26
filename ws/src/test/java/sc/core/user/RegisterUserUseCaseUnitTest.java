package sc.core.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sc.adapter.persistence.user.UserPersistenceAdapter;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.application.service.UserRegistrationService;
import sc.core.user.domain.Credentials;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PASSWORD;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PHONE;
import static sc.core.user.domain.RoleEnum.USER;

@ExtendWith(MockitoExtension.class)
class RegisterUserUseCaseUnitTest {

    private RegisterUserUseCase registerUserUseCase;

    @Mock
    private UserPersistenceAdapter userPersistenceAdapter;

    @BeforeEach
    void init() {
        registerUserUseCase = new UserRegistrationService(userPersistenceAdapter, new BCryptPasswordEncoder());
    }

    @Test
    void saveFullUserWithoutValidation() {
        User userToSave = createValidUser();

        when(userPersistenceAdapter.saveUser(userToSave))
                .thenAnswer(invocation -> {
                    User userArg = invocation.getArgument(0);
                    return new User()
                            .setId(userArg.getId())
                            .setCredentials(new Credentials()
                                    .setUsername(userArg.getCredentials().getUsername())
                                    .setPassword(userArg.getCredentials().getPassword()))
                            .setRoles(userArg.getRoles());
                });

        User savedUser = registerUserUseCase.registerUser(userToSave);

        assertEquals(userToSave, savedUser);
    }

    @Test
    void settingUserRole() {
        User userToSave = createValidUser();

        when(userPersistenceAdapter.saveUser(userToSave))
                .thenAnswer(invocation -> {
                    User userArg = invocation.getArgument(0);
                    return new User()
                            .setRoles(userArg.getRoles());
                });

        Set<Long> roleIdSet = registerUserUseCase.registerUser(userToSave).getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet());

        assertThat(roleIdSet, contains(USER.getId()));
    }

    @Test
    void encodingUserPassword() {
        User userToSave = createValidUser();

        when(userPersistenceAdapter.saveUser(userToSave))
                .thenAnswer(invocation -> {
                    User userArg = invocation.getArgument(0);
                    return new User()
                            .setCredentials(new Credentials()
                                    .setPassword(userArg.getCredentials().getPassword()));
                });

        String encodedPassword = registerUserUseCase.registerUser(userToSave).getCredentials().getPassword();

        assertNotNull(encodedPassword);
        assertNotEquals(VALID_PASSWORD, encodedPassword);
        assertTrue(encodedPassword.startsWith(BCryptPasswordEncoder.BCryptVersion.$2A.getVersion()));
    }

    private User createValidUser() {
        return new User()
                .setCredentials(new Credentials()
                        .setUsername(VALID_PHONE)
                        .setPassword(VALID_PASSWORD));
    }

}