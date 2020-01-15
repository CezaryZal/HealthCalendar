package com.CezaryZal.exceptions.not.found;

public class DayNotFoundException extends RuntimeException{
    public DayNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
