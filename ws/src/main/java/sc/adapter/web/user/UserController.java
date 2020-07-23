package sc.adapter.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.core.user.application.port.in.RegisterUserUseCase;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;

    private final UserWebMapper mapper;

    @PostMapping("user")
    public void registerUser(UserDTO user) {
        registerUserUseCase.registerUser(mapper.toDomainEntity(user));
    }
}
