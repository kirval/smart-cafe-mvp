package sc.adapter.persistence.user;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sc.configuration.FlywayMigrationConfig;
import sc.core.user.domain.Credentials;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PASSWORD;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PHONE;
import static sc.core.user.domain.RoleEnum.USER;

@DataJpaTest
@Import(FlywayMigrationConfig.class)
@ComponentScan(basePackages = "sc.adapter.persistence.user")
class UserPersistenceAdapterIntegrationTest {

    @TestConfiguration
    static class TestConfig {

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

    @Autowired
    private UserPersistenceAdapter userPersistenceAdapter;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FlywayMigrationStrategy strategy;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    void init() {
        strategy.migrate(flyway);
    }

    @Test
    void saveValidUser() {
        User validUserToSave = new User()
                .setCredentials(new Credentials()
                        .setUsername(VALID_PHONE)
                        .setPassword(VALID_PASSWORD))
                .setRoles(Collections.singleton(new Role()
                        .setId(USER.getId())));

        User savedUser = userPersistenceAdapter.saveUser(validUserToSave);
        entityManager.flush();
        entityManager.clear();

        assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getCredentials().getUsername());
        assertNotNull(savedUser.getCredentials().getPassword());
        assertEquals(1, savedUser.getRoles().size());
    }

}