package sc.adapter.persistence.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static sc.core.user.domain.RoleEnum.USER;

@DataJpaTest
@ComponentScan(basePackages = "sc.adapter.persistence.user")
class UserPersistenceAdapterIntegrationTest {

    @Autowired
    private UserPersistenceAdapter userPersistenceAdapter;

    @Test
    void saveValidUser() {
        User validUserToSave = new User()
                .setEmail("email@email.com")
                .setPassword("password")
                .setRoles(Collections.singleton(new Role().setId(USER.getId())));

        User savedUser = userPersistenceAdapter.saveUser(validUserToSave);

        assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getEmail());
        assertNotNull(savedUser.getPassword());
        assertEquals(1, savedUser.getRoles().size()); //todo check rolejpa value field after fetch (null)
    }

}