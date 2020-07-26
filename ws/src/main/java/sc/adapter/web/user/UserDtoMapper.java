package sc.adapter.web.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sc.core.user.domain.User;

@Mapper
public interface UserDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "credentials.username", source = "phone")
    @Mapping(target = "credentials.password", source = "password")
    @Mapping(target = "roles", ignore = true)
    User toDomainEntity(UserDtoIn user);

}
