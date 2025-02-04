package banquemisr.challenege05.taskmangmentsystem.customannotation;

import banquemisr.challenege05.taskmangmentsystem.datatransferopject.TasksTransferOpject;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaskSearchValidator implements ConstraintValidator<ValidTaskSearch, TasksTransferOpject> {

    @Override
    public void initialize(ValidTaskSearch constraintAnnotation) {
    }

    @Override
    public boolean isValid(TasksTransferOpject value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Handle null cases if necessary
        }

        String operation = value.getOperation();

        // Validate operation
        if (operation != null
                && !("Title".equals(operation) || "Description".equals(operation) || "Status".equals(operation))) {
            return false;
        }

        return true;
    }
}
