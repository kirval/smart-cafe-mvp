package sc.adapter.persistence.user.role;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import sc.core.user.domain.Role;

@Mapper
public interface RoleJpaMapper {

    String ROLE_DOMAIN_TO_JPA_ONLY_ID = "roleToJpaOnlyId";
    String ROLE_JPA_TO_DOMAIN_FULL = "roleJpaToDomainFull";

    @Named(ROLE_DOMAIN_TO_JPA_ONLY_ID)
    default RoleJpa toJpaEntityOnlyId(Role domainEntity) {
        if (domainEntity != null) {
            return new RoleJpa().setId(domainEntity.getId());
        } else {
            return null; //todo throw exception
        }
    }

    @Named(ROLE_JPA_TO_DOMAIN_FULL)
    Role toDomainEntityFull(RoleJpa jpaEntity);

}
