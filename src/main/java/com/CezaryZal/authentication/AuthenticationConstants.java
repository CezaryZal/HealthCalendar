package com.CezaryZal.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationConstants {

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String ROLES_KEY = "roles";
    public static final String NAME_KEY = "name";
    public static String SECRET_KEY;

    public AuthenticationConstants() {
    }

    @Value("${authorization.jwt.secret.key}")
    private void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }
}
