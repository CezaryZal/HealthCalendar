package com.CezaryZal.exceptions;

public class DailyLimitsNotFoundException extends RuntimeException{
    public DailyLimitsNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
