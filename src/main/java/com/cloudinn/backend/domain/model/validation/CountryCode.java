package com.cloudinn.backend.domain.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryCodeValidator.class)
@Documented
public @interface CountryCode {
    String message() default "Invalid country code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
