package sc.core.user.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import sc.adapter.persistence.user.UserPersistenceAdapter;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.domain.User;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
public class UserRegistrationService implements RegisterUserUseCase {

    private final UserPersistenceAdapter userPersistenceAdapter;

    @Override
    public User registerUser(@Valid User user) {
        return userPersistenceAdapter.saveUser(user);
    }

}
