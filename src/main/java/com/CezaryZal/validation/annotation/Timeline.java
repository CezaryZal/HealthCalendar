package com.CezaryZal.validation.annotation;

import com.CezaryZal.validation.validator.ActualDateConstraintValidator;
import com.CezaryZal.validation.validator.TimelineConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = TimelineConstraintValidator.class)
@Documented
public @interface Timeline {

    String message () default "The training time should be between 0:01 and 3:00 hours";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
