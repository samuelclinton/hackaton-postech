package com.cloudinn.backend.domain.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Locale;

public class CountryCodeValidator implements ConstraintValidator<CountryCode, String> {

    @Override
    public void initialize(CountryCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean stringIsIsoCountry = Arrays.asList(Locale.getISOCountries()).contains(s);
        return s == null || stringIsIsoCountry;
    }

}
