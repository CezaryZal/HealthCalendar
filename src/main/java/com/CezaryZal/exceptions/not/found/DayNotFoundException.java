package com.CezaryZal.exceptions.not.found;

public class DayNotFoundException extends ApiModelNotFoundException {

    public DayNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
