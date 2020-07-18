package sc.core.user.application.port.out;

import sc.core.user.domain.User;

public interface UserPersistencePort {

    User saveUser(User user);

}
