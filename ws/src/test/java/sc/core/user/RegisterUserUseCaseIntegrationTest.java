package sc.core.user;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sc.configuration.FlywayMigrationConfig;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.domain.Credentials;
import sc.core.user.domain.User;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PASSWORD;
import static sc.core.user.RegisterUserUseCaseConstants.VALID_PHONE;

@DataJpaTest
@Import({FlywayMigrationConfig.class, ValidationAutoConfiguration.class})
@ComponentScan(basePackages = {"sc.core.user", "sc.adapter.persistence.user", "org.springframework.validation"})
class RegisterUserUseCaseIntegrationTest {

    @Autowired
    private RegisterUserUseCase registerUserUseCase;

    @Autowired
    private FlywayMigrationStrategy strategy;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    void init() {
        strategy.migrate(flyway);
    }

    @Test
    void saveUserWithInvalidPhoneThrowsException() {
        User userWithInvalidPhone = new User()
                .setCredentials(new Credentials()
                        .setUsername("123")
                        .setPassword(VALID_PASSWORD));

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithInvalidPhone));
    }

    @Test
    void saveUserWithValidCredentialsDoesNotThrowException() {
        User userWithValidPhone = new User()
                .setCredentials(new Credentials()
                        .setUsername(VALID_PHONE)
                        .setPassword(VALID_PASSWORD));

        assertDoesNotThrow(() -> registerUserUseCase.registerUser(userWithValidPhone));
    }

    @Test
    void saveUserWithoutPhoneThrowsException() {
        User userWithoutEmailAndPhone = new User()
                .setCredentials(new Credentials()
                        .setPassword(VALID_PASSWORD));

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithoutEmailAndPhone));
    }

    @Test
    void saveUserWithInvalidPasswordThrowsException() {
        User userWithInvalidPassword = new User()
                .setCredentials(new Credentials()
                        .setUsername(VALID_PHONE)
                        .setPassword("Passw0 r@"));

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithInvalidPassword));
    }

}