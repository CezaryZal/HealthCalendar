package com.CezaryZal.exceptions.not.found;

public class DailyLimitsNotFoundException extends ApiModelNotFoundException {

    public DailyLimitsNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
