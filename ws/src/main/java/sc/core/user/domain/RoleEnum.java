package sc.core.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
@AllArgsConstructor
public enum RoleEnum {

    USER(1L),
    ADMIN(2L);

    private final Long id;

    public static RoleEnum findById(Long id) {
        if (id != null) {
            for (RoleEnum type : values()) {
                if (type.id.equals(id)) {
                    return type;
                }
            }
        }
        throw new NoSuchElementException(String.format("Role with id = %s was not found.", id));
    }


}
