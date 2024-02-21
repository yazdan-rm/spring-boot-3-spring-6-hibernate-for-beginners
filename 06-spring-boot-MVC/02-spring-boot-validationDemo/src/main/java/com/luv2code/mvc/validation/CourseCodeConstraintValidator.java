package com.luv2code.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePreFix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        // assign the value passed in from our annotation
        this.coursePreFix = constraintAnnotation.value();
    }


    // business rules has been implemented in this method
    @Override
    public boolean isValid(String theCode /*Code From HTML From*/,
                           ConstraintValidatorContext constraintValidatorContext /* Add more error message with this*/) {

        if(theCode != null) {
            return theCode.startsWith(coursePreFix);
        }
        return true;
    }
}
