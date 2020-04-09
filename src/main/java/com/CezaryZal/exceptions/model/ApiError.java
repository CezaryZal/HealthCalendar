package com.CezaryZal.exceptions.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@EqualsAndHashCode
public class ApiError {

    private Date timestamp;
    private String path;
    private HttpMethod httpMethod;
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(Date timestamp,
                    String path,
                    HttpMethod httpMethod,
                    HttpStatus status,
                    String message,
                    List<String> errors) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.httpMethod = httpMethod;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(Date timestamp,
                    String path,
                    HttpMethod httpMethod,
                    HttpStatus status,
                    String message,
                    String error) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.httpMethod = httpMethod;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
