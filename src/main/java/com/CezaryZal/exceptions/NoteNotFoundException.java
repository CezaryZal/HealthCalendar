package com.CezaryZal.exceptions;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
