package com.CezaryZal.exceptions;

public class TrainingNotFoundException extends RuntimeException {
    public TrainingNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
