package com.CezaryZal.exceptions.not.found;

public class ShortReportNotFoundException extends RuntimeException{
    public ShortReportNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
