package banquemisr.challenege05.taskmangmentsystem.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PositiveIdValidator implements ConstraintValidator<ValidId, Long> {

    @Override
    public void initialize(ValidId constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return id != null && id > 0;
    }
}
