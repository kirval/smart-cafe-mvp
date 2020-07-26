package sc.core.user.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Credentials {

    @NotBlank
    @Pattern(regexp = "^\\+375(?:[0-9]{4,12})$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*=_+])(?=\\S+$).{8,16}$")
    private String password;

}
