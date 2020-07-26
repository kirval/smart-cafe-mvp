package sc.core.user.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import sc.adapter.persistence.user.UserPersistenceAdapter;
import sc.common.validation.group.Create;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static sc.core.user.domain.RoleEnum.USER;

@Service
@RequiredArgsConstructor
@Validated
public class UserRegistrationService implements RegisterUserUseCase {

    private final UserPersistenceAdapter userPersistenceAdapter;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Validated(Create.class)
    public User registerUser(@Valid User user) {
        encodePassword(user);
        addRoleUser(user);

        return userPersistenceAdapter.saveUser(user);
    }

    private void encodePassword(User user) {
        String rawPassword = user.getCredentials().getPassword();
        user.getCredentials().setPassword(passwordEncoder.encode(rawPassword));
    }

    private void addRoleUser(User user) {
        Set<Role> roles = new HashSet<>(Collections.singletonList(
                new Role().setId(USER.getId())));
        user.setRoles(roles);
    }

}
