package com.CezaryZal.exceptions.not.found;

public class TrainingNotFoundException extends RuntimeException {
    public TrainingNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
