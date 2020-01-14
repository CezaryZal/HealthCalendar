package com.CezaryZal.exceptions;

public class MealNotFoundException extends RuntimeException{
    public MealNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
