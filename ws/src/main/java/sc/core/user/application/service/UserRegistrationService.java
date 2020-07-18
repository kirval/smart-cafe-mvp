package sc.core.user.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.adapter.persistence.user.UserPersistenceAdapter;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.domain.User;

@Service
@RequiredArgsConstructor
public class UserRegistrationService implements RegisterUserUseCase {

    private final UserPersistenceAdapter userPersistenceAdapter;

    @Override
    public User registerUser(User user) {
        return null;
    }

}
