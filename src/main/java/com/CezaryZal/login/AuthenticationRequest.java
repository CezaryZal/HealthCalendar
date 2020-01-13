package com.CezaryZal.login;

import com.CezaryZal.api.user.entity.FormUser;

public class AuthenticationRequest extends FormUser {

    public AuthenticationRequest(String loginName, String password) {
        super(loginName, password);
    }

    @Override
    public String getLoginName() {
        return super.getLoginName();
    }

}
