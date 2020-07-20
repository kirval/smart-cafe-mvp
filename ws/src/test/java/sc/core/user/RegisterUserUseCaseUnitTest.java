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
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static sc.core.user.RegisterUserUseCaseConstants.*;
import static sc.core.user.domain.RoleEnum.USER;

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
                .setEmail(VALID_EMAIL)
                .setPhone(VALID_PHONE)
                .setPassword(VALID_PASSWORD)
                .setRoles(new HashSet<>(Collections.singletonList(new Role())));

        when(userPersistenceAdapter.saveUser(userToSave))
                .thenAnswer(invocation -> {
                    User userArg = invocation.getArgument(0);
                    return new User()
                            .setId(userArg.getId())
                            .setEmail(userArg.getEmail())
                            .setPhone(userArg.getPhone())
                            .setPassword(userArg.getPassword())
                            .setRoles(userArg.getRoles());
                });

        User savedUser = registerUserUseCase.registerUser(userToSave);

        assertEquals(userToSave, savedUser);
    }

    @Test
    void settingUserRole() {
        User userToSave = new User()
                .setEmail(VALID_EMAIL)
                .setPassword(VALID_PASSWORD);

        when(userPersistenceAdapter.saveUser(userToSave))
                .thenAnswer(invocation -> {
                    User userArg = invocation.getArgument(0);
                    return new User()
                            .setId(userArg.getId())
                            .setEmail(userArg.getEmail())
                            .setPhone(userArg.getPhone())
                            .setPassword(userArg.getPassword())
                            .setRoles(userArg.getRoles());
                });

        Set<Long> roleIdSet = registerUserUseCase.registerUser(userToSave).getRoles().stream()
                .map(Role::getId)
                .collect(Collectors.toSet());

        assertThat(roleIdSet, contains(USER.getId()));
    }

}