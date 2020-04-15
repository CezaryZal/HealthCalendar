package com.CezaryZal.exceptions.not.found;

public class UserNotFoundException extends ApiModelNotFoundException {

    public UserNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
