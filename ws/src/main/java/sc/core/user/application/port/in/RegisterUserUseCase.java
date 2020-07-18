package sc.core.user.application.port.in;

import sc.core.user.domain.User;

public interface RegisterUserUseCase {

    User registerUser(User user);

}
