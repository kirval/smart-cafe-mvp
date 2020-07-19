package sc.core.user.application.port.in;

import sc.core.user.domain.User;

import javax.validation.Valid;

public interface RegisterUserUseCase {

    User registerUser(@Valid User user);

}
