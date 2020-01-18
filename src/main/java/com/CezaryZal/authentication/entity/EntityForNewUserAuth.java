package com.CezaryZal.authentication.entity;

public class EntityForNewUserAuth extends FormAuthenticationEntity{

    private String permissions;

    public EntityForNewUserAuth(
            String loginName,
            String password,
            String permissions) {
        super(loginName, password);
        this.permissions = permissions;
    }
}
