package sc.adapter.web.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoIn {

    @NotBlank
    private String phone;

    @NotBlank
    private String password;

}
