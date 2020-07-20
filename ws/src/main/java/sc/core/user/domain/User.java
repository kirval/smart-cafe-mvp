package sc.core.user.domain;

import lombok.Data;
import sc.core.user.validation.EmailOrPhoneIsNotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@EmailOrPhoneIsNotBlank
public class User {

    //todo add validation groups: save -> null, update -> not null.
    // add related exception in service
    private Long id;

    @Email
    private String email;

    @Pattern(regexp = "^\\+375(?:[0-9]{4,12})$")
    private String phone;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*=_+])(?=\\S+$).{8,16}$")
    private String password;
    private Set<Role> roles;

}
