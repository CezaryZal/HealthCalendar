package com.CezaryZal.authentication.entity;

public class AuthenticationRequest extends FormAuthenticationEntity{

    public AuthenticationRequest(String loginName, String password) {
        super(loginName, password);
    }
}
