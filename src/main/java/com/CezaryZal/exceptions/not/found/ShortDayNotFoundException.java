package com.CezaryZal.exceptions.not.found;

public class ShortDayNotFoundException extends RuntimeException{
    public ShortDayNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
