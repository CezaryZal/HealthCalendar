package com.CezaryZal.exceptions.not.found;

public class NoteNotFoundException extends ApiModelNotFoundException {

    public NoteNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
