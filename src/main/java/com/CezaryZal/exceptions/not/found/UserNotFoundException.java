package com.CezaryZal.exceptions.not.found;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
