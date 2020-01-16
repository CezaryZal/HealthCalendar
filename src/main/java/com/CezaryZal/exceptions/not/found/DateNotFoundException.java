package com.CezaryZal.exceptions.not.found;

public class DateNotFoundException extends RuntimeException{

    public DateNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
