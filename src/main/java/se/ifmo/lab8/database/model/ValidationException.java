package se.ifmo.lab8.database.model;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class ValidationException extends RuntimeException {
    private Set<ConstraintViolation<?>> constraintViolations;

    public ValidationException(Set<ConstraintViolation<?>> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    public Set<ConstraintViolation<?>> getConstraintViolations() {
        return constraintViolations;
    }
}
