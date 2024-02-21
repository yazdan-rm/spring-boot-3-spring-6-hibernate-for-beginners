package com.luv2code.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    String value() default "LUV";

    // define default error message
    String message() default "must start with LUV";

    // define default groups
    Class<?>[] groups() default {};

    // define default payloads
    Class<? extends Payload>[] payload() default {};

}
