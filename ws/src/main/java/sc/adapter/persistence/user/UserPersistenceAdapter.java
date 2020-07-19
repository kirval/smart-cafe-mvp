package sc.adapter.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sc.core.user.application.port.out.UserPersistencePort;
import sc.core.user.domain.User;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

//    private final UserRepository repository;

    @Override
    public User saveUser(User user) {
        return null;
    }


}
