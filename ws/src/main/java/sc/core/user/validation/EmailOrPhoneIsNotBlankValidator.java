package sc.core.user.validation;

import sc.core.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailOrPhoneIsNotBlankValidator implements ConstraintValidator<EmailOrPhoneIsNotBlank, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        return (user.getEmail() != null && !user.getEmail().isBlank()) ||
                (user.getPhone() != null && !user.getPhone().isBlank());
    }

}
