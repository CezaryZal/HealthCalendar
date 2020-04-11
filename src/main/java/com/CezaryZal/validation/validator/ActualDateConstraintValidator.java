package com.CezaryZal.validation.validator;

import com.CezaryZal.validation.annotation.ActualDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class ActualDateConstraintValidator implements ConstraintValidator<ActualDate, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime inputDateTime, ConstraintValidatorContext context) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (inputDateTime == null){
            return true;
        }

        return inputDateTime.isBefore(currentDateTime.plusHours(24)) &&
                inputDateTime.isAfter(currentDateTime.minusHours(24));
    }

}
