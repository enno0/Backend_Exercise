package banquemisr.challenege05.taskmangmentsystem.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PositiveIdValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidId {
    String message() default "Invalid ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
