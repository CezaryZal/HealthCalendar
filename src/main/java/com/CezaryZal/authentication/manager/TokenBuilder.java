package com.CezaryZal.authentication.manager;

import com.CezaryZal.constants.AuthenticationConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenBuilder {

    String buildTokenByUser(String loginName, String roles){
        String secret = AuthenticationConstants.SECRET_KEY;

        return Jwts
                .builder()
                .setSubject(AuthenticationConstants.TOKEN_SUBJECT)
                .setIssuer(AuthenticationConstants.TOKEN_ISSUER)
                .setAudience(AuthenticationConstants.TOKEN_AUDIENCE)
                .claim(AuthenticationConstants.NAME_KEY, loginName)
                .claim(AuthenticationConstants.ROLES_KEY, AuthenticationConstants.TOKEN_PREFIX_ROLE + roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + AuthenticationConstants.JWT_EXPIRE_IN_MILLISECOND))
                .signWith(SignatureAlgorithm.HS384, secret.getBytes())
                .compact();

    }

}
