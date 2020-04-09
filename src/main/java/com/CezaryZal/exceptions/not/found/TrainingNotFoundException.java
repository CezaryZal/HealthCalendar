package com.CezaryZal.exceptions.not.found;

public class TrainingNotFoundException extends ApiModelNotFoundException {

    public TrainingNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
