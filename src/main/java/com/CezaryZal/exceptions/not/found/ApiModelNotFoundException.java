package com.CezaryZal.exceptions.not.found;

public class ApiModelNotFoundException extends RuntimeException{

    ApiModelNotFoundException(String massage) {
        super(massage);
    }
}
