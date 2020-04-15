package com.CezaryZal.validation.annotation;

import com.CezaryZal.validation.validator.ActualDateConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ActualDateConstraintValidator.class)
@Documented
public @interface ActualDate {

    String message () default "The date time should be current";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};

}
