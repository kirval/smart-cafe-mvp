package sc.core.user.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailOrPhoneIsNotBlankValidator.class)
@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface EmailOrPhoneIsNotBlank {

    String message() default "Email or phone is blank.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
