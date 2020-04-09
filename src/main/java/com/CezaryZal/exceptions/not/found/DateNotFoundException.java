package com.CezaryZal.exceptions.not.found;

public class DateNotFoundException extends ApiModelNotFoundException {

    public DateNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
