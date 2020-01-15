package com.CezaryZal.exceptions.not.found;

public class DailyLimitsNotFoundException extends RuntimeException{
    public DailyLimitsNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
