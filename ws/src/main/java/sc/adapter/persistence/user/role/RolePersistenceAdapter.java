package sc.adapter.persistence.user.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter {

    private final RoleRepository repository;

}
