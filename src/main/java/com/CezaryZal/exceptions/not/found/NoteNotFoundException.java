package com.CezaryZal.exceptions.not.found;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
