package com.CezaryZal.exceptions.not.found;

public class MealNotFoundException extends RuntimeException{
    public MealNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
