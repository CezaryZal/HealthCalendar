package com.CezaryZal.api.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class FormUser {

    public FormUser(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    private String loginName;
    private String password;
    private String email;
}
