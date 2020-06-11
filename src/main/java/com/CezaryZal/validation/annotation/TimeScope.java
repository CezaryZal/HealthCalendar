package com.CezaryZal.validation.annotation;

import com.CezaryZal.validation.validator.TimeScopeConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = TimeScopeConstraintValidator.class)
@Documented
public @interface TimeScope {

    String message () default "The training time should be between 0:01 and 3:00 hours";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
