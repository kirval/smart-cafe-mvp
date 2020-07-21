package sc.adapter.persistence.user;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import sc.adapter.persistence.user.role.RoleJpa;
import sc.configuration.FlywayMigrationConfig;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static sc.core.user.domain.RoleEnum.USER;

@DataJpaTest
@Import(FlywayMigrationConfig.class)
@ComponentScan(basePackages = "sc.adapter.persistence.user")
class UserPersistenceAdapterIntegrationTest {


    @Autowired
    private FlywayMigrationStrategy strategy;

    @Autowired
    private Flyway flyway;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserPersistenceAdapter userPersistenceAdapter;

    @BeforeEach
    void init() {
        strategy.migrate(flyway);
    }

    @Test
    void saveValidUser() {
        User validUserToSave = new User()
                .setEmail("email@email.com")
                .setPassword("password")
                .setRoles(Collections.singleton(new Role()
                        .setId(USER.getId())));

        User savedUser = userPersistenceAdapter.saveUser(validUserToSave);
        entityManager.flush();
        entityManager.clear();

        assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getEmail());
        assertNotNull(savedUser.getPassword());
        assertEquals(1, savedUser.getRoles().size());
    }

}