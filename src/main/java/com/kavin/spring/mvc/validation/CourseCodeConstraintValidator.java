package com.kavin.spring.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {


    private String prefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        prefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(prefix);
        } else {
            return false;  // If empty string is invalid
        }

        return result;


    }

}
