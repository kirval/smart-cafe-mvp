package sc.core.user.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class User {

    private Long id;

    @Email
    private String email;
    private String phone;

    @NotBlank
    private String password;
    private Set<Role> roles;

}
