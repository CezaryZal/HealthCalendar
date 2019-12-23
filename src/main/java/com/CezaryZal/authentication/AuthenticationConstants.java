package com.CezaryZal.authentication;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationConstants {

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String ROLES_KEY = "roles";
    public static final String NAME_KEY = "name";
//    public static String SECRET_KEY;
    public static String SECRET_KEY = "dFKYX}&[K;'{{;q";
    public static Long JWT_EXPIRE_IN_MINUTES;
    public static Long REFRESH_TOKEN_EXPIRE_IN_MINUTES;
    public AuthenticationConstants() {
    }
//    @Value("${authorization.jwt.token.expire.time.in.minutes}")
//    private void setJwtExpireInMinutes(Long jwtExpireInMinutes) {
//        JWT_EXPIRE_IN_MINUTES = jwtExpireInMinutes;
//    }
//    @Value("${authorization.refresh.token.expire.time.in.minutes}")
//    private void setRefreshTokenExpireInMinutes(Long refreshTokenExpireInMinutes) {
//        REFRESH_TOKEN_EXPIRE_IN_MINUTES = refreshTokenExpireInMinutes;
//    }
//    @Value("${authorization.jwt.secretkey}")
//    private void setSecretKey(String secretKey) {
//        this.SECRET_KEY = secretKey;
//    }
}
