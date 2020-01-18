package com.CezaryZal.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormAuthenticationEntity {

    private String loginName;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
