package sc.adapter.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.core.user.application.port.in.RegisterUserUseCase;

import javax.validation.Valid;

import static sc.adapter.web.user.UserConstants.USER_ENDPOINT;

@RestController
@RequestMapping(USER_ENDPOINT)
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final UserDtoMapper mapper;

    @PostMapping
    public void registerUser(@Valid @RequestBody UserDtoIn user) {
        registerUserUseCase.registerUser(mapper.toDomainEntity(user));
    }

}
