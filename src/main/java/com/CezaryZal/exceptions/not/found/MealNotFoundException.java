package com.CezaryZal.exceptions.not.found;

public class MealNotFoundException extends ApiModelNotFoundException {

    public MealNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
