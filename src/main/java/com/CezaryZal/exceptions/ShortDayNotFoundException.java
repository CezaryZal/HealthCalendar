package com.CezaryZal.exceptions;

public class ShortDayNotFoundException extends RuntimeException{
    public ShortDayNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
