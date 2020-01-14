package com.CezaryZal.exceptions;

public class DayNotFoundException extends RuntimeException{
    public DayNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
