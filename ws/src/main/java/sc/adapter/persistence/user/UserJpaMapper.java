package sc.adapter.persistence.user;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import sc.adapter.persistence.user.role.RoleJpa;
import sc.adapter.persistence.user.role.RoleJpaMapper;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import java.util.Set;

import static sc.adapter.persistence.user.role.RoleJpaMapper.ROLE_DOMAIN_TO_JPA_ONLY_ID;
import static sc.adapter.persistence.user.role.RoleJpaMapper.ROLE_JPA_TO_DOMAIN_FULL;

@Mapper(uses = {
        RoleJpaMapper.class
})
public interface UserJpaMapper {

    UserJpa toJpaEntity(User domainEntity);

    @IterableMapping(qualifiedByName = ROLE_DOMAIN_TO_JPA_ONLY_ID)
    Set<RoleJpa> roleDomainToJpaSet(Set<Role> set);

    User toDomainEntity(UserJpa jpaEntity);

    @IterableMapping(qualifiedByName = ROLE_JPA_TO_DOMAIN_FULL)
    Set<Role> roleJpaToDomainSet(Set<RoleJpa> set);

}
