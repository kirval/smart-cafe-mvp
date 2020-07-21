package sc.core.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import sc.core.user.application.port.in.RegisterUserUseCase;
import sc.core.user.domain.Role;
import sc.core.user.domain.User;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static sc.core.user.RegisterUserUseCaseConstants.*;

@DataJpaTest
@Import(ValidationAutoConfiguration.class)
@ComponentScan(basePackages = {"sc.core.user", "sc.adapter.persistence.user", "org.springframework.validation"})
class RegisterUserUseCaseIntegrationTest {

    @Autowired
    private RegisterUserUseCase registerUserUseCase;

    @Test
    void saveUserWithInvalidEmailThrowsException() {
        User userWithInvalidEmail = new User()
                .setEmail("invalidemail")
                .setPassword(VALID_PASSWORD);

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithInvalidEmail));
    }

    @Test
    void saveUserWithValidEmailDoesNotThrowException() {
        User userWithInvalidEmail = new User()
                .setEmail(VALID_EMAIL)
                .setPassword(VALID_PASSWORD);

        assertDoesNotThrow(() -> registerUserUseCase.registerUser(userWithInvalidEmail));
    }

    @Test
    void saveUserWithInvalidPhoneThrowsException() {
        User userWithInvalidPhone = new User()
                .setPhone("123")
                .setPassword(VALID_PASSWORD);

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithInvalidPhone));
    }

    @Test
    void saveUserWithValidPhoneDoesNotThrowException() {
        User userWithValidPhone = new User()
                .setPhone(VALID_PHONE)
                .setPassword(VALID_PASSWORD);

        assertDoesNotThrow(() -> registerUserUseCase.registerUser(userWithValidPhone));
    }

    @Test
    void saveUserWithoutEmailAndPhoneThrowsException() {
        User userWithoutEmailAndPhone = new User()
                .setPassword(VALID_PASSWORD);

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithoutEmailAndPhone));
    }

    @Test
    void saveUserWithEmailOrPhoneDoesNotThrowException() {
        User userWithEmail = new User()
                .setEmail(VALID_EMAIL)
                .setPassword(VALID_PASSWORD);
        User userWithPhone = new User()
                .setPhone(VALID_PHONE)
                .setPassword(VALID_PASSWORD);

        assertDoesNotThrow(() -> registerUserUseCase.registerUser(userWithEmail));
        assertDoesNotThrow(() -> registerUserUseCase.registerUser(userWithPhone));
    }

    @Test
    void saveUserWithInvalidPasswordThrowsException() {
        User userWithInvalidPassword = new User()
                .setEmail(VALID_EMAIL)
                .setPassword("Passw0 r@");

        assertThrows(ConstraintViolationException.class, () -> registerUserUseCase.registerUser(userWithInvalidPassword));
    }

    @Test
    void saveUserWithValidPasswordDoesNotThrowException() {
        User userWithValidPassword = new User()
                .setEmail(VALID_EMAIL)
                .setPassword(VALID_PASSWORD)
                .setRoles(new HashSet<>(Collections.singletonList(new Role())));

        assertDoesNotThrow(() -> registerUserUseCase.registerUser(userWithValidPassword));
    }

}