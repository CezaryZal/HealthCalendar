package com.CezaryZal.exceptions;

public class BodySizeNotFoundException extends RuntimeException{
    public BodySizeNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
