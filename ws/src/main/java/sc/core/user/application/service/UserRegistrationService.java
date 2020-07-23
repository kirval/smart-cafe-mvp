package sc.core.user.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.application.port.out.UserPersistencePort;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;

import static sc.core.user.domain.RoleEnum.USER;

@Service
@Validated
@RequiredArgsConstructor
public class UserRegistrationService implements RegisterUserUseCase {

    private final UserPersistencePort userPersistencePort;

    @Override
    public User registerUser(@Valid User user) {
        user.setRoles(new HashSet<>(Collections.singletonList(new Role()
                .setId(USER.getId()))));

        return userPersistencePort.saveUser(user);
    }

}
