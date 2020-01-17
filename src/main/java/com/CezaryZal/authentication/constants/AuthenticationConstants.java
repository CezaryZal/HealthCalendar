package com.CezaryZal.authentication.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationConstants {

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String ROLES_KEY = "roles";
    public static final String NAME_KEY = "name";
    public static String SECRET_KEY;
    public static final String TOKEN_SUBJECT = "Subject";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
    public static final String TOKEN_PREFIX_ROLE = "ROLE_";
    public static Long JWT_EXPIRE_IN_MILLISECOND;

    public AuthenticationConstants() {
    }

    @Value("${authorization.jwt.secret.key}")
    private void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

    @Value("${authorization.jwt.token.expire.time.in.millisecond}")
    private void setJwtExpireInMinutes(Long jwtExpireInMinutes) {
        JWT_EXPIRE_IN_MILLISECOND = jwtExpireInMinutes;
    }

}
