package sc.adapter.web.user;

import org.mapstruct.Mapper;
import sc.core.user.domain.User;

@Mapper
public interface UserWebMapper {
    User toDomainEntity(UserDTO user);

    UserDTO toUserDTO(User user);
}
