package com.CezaryZal.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class AuthenticationRequest{

    private String loginName;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
