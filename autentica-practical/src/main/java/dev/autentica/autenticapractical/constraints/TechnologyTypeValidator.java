package dev.autentica.autenticapractical.constraints;

import dev.autentica.autenticapractical.util.TechnologyType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TechnologyTypeValidator implements ConstraintValidator<TechnologyTypeConstraint, String>  {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        TechnologyType[] technologyTypes = TechnologyType.values();
        for (TechnologyType tech : technologyTypes) {
            if (tech.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
