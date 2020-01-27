package com.CezaryZal.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ObjectToAuthResponse {

    private Long userId;
    private String password;
    private String roles;

}
