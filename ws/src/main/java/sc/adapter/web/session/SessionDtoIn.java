package sc.adapter.web.session;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SessionDtoIn {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
