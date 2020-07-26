package sc.core.user.domain;

import lombok.Data;
import sc.common.validation.group.Create;
import sc.common.validation.group.Update;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.Set;

@Data
public class User {

    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private Long id;

    @Valid
    @ConvertGroup(from = Create.class, to = Default.class)
    private Credentials credentials;

    private Set<Role> roles;

}
