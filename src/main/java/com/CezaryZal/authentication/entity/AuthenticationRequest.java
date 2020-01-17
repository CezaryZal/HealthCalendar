package com.CezaryZal.authentication.entity;

import com.CezaryZal.api.user.entity.FormUser;

public class AuthenticationRequest extends FormUser {

    public AuthenticationRequest(String loginName, String password) {
        super(loginName, password);
    }

}
