package com.backend_xeercise.taskmanagementsystem.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CapitalCaseValidator implements ConstraintValidator<CapitalCase, String> {

    @Override
    public void initialize(CapitalCase constraintAnnotation) {
        // Initialization logic if needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // Consider empty value as valid, use @NotNull for null check
        }
        return value.equals(value.toUpperCase());
    }
}