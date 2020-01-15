package com.CezaryZal.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
