package com.CezaryZal.exceptions.not.found;

public class BodySizeNotFoundException extends RuntimeException{
    public BodySizeNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
