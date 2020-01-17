package com.CezaryZal.authentication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthenticationRequest {

    private String loginName;
    private String password;

}
