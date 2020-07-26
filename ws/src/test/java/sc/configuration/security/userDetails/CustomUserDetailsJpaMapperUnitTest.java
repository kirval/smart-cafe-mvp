package sc.configuration.security.userDetails;

import org.junit.jupiter.api.Test;
import sc.adapter.persistence.user.UserJpa;
import sc.adapter.persistence.user.role.RoleJpa;
import sc.adapter.persistence.user.role.RoleNameEnum;
import sc.core.user.domain.RoleEnum;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PASSWORD;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PHONE;

class CustomUserDetailsJpaMapperUnitTest {

    private final CustomUserDetailsMapper mapper = new CustomUserDetailsMapperImpl();

    @Test
    void mapToCustomUserDetails() {
        UserJpa userToMap = new UserJpa()
                .setId(1L)
                .setPhone(VALID_PHONE)
                .setPassword(VALID_PASSWORD)
                .setRoles(new HashSet<>(Collections.singletonList(new RoleJpa()
                        .setId(RoleEnum.USER.getId())
                        .setName(RoleNameEnum.ROLE_USER))));

        CustomUserDetails userDetails = mapper.toCustomUserDetails(userToMap);

        assertEquals(userDetails.getId(), userToMap.getId());
        assertEquals(userDetails.getUsername(), userToMap.getPhone());
        assertEquals(userDetails.getPassword(), userToMap.getPassword());
        assertEquals(userDetails.getAuthorities().size(), 1);
        assertEquals(userDetails.getAuthorities().iterator().next().getAuthority(), RoleNameEnum.ROLE_USER.toString());
    }

}