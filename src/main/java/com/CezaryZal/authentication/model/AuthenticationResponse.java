package com.CezaryZal.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;
    private Long userId;
}
