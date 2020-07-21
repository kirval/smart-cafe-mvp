package sc.adapter.persistence.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sc.adapter.persistence.user.role.RoleJpa;
import sc.adapter.persistence.user.role.RoleRepository;
import sc.core.user.application.port.out.UserPersistencePort;
import sc.core.user.domain.User;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository repository;
    private final UserJpaMapper mapper;

    @Override
    public User saveUser(User user) {
        return mapper.toDomainEntity(
                repository.save(mapper.toJpaEntity(user)));
    }

}
