package sc.configuration.security.userDetails;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import sc.adapter.persistence.user.UserJpa;
import sc.adapter.persistence.user.role.RoleJpa;

import java.util.Set;

@Mapper
public interface CustomUserDetailsMapper {

    String ROLE_JPA_TO_GRANTED_AUTHORITY = "RoleJpaToGrantedAuthority";


    @Mapping(target = "username", source = "phone")
    @Mapping(target = "authorities", source = "roles")
    CustomUserDetails toCustomUserDetails(UserJpa userJpa);

    @IterableMapping(qualifiedByName = ROLE_JPA_TO_GRANTED_AUTHORITY)
    Set<GrantedAuthority> toAuthoritySet(Set<RoleJpa> roleSet);

    @Named(ROLE_JPA_TO_GRANTED_AUTHORITY)
    default GrantedAuthority toAuthority(RoleJpa roleJpa) {
        return new SimpleGrantedAuthority(roleJpa.getName().toString());
    }

}
