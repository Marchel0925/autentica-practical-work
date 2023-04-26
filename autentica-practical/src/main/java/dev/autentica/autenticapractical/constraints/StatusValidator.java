package dev.autentica.autenticapractical.constraints;

import dev.autentica.autenticapractical.util.Status;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<StatusConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            if (status.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
