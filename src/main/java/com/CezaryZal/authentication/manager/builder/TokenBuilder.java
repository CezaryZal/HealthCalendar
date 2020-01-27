package com.CezaryZal.authentication.manager.builder;

import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.constants.AuthenticationConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenBuilder {

    public String buildTokenByUser(UserAuthentication userAuthentication){
        String secret = AuthenticationConstants.SECRET_KEY;

        return Jwts
                .builder()
                .setSubject(AuthenticationConstants.TOKEN_SUBJECT)
                .setIssuer(AuthenticationConstants.TOKEN_ISSUER)
                .setAudience(AuthenticationConstants.TOKEN_AUDIENCE)
                .claim(AuthenticationConstants.NAME_KEY, userAuthentication.getLoginName())
                .claim(AuthenticationConstants.ROLES_KEY, AuthenticationConstants.TOKEN_PREFIX_ROLE + userAuthentication.getRoles())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + AuthenticationConstants.JWT_EXPIRE_IN_MILLISECOND))
                .signWith(SignatureAlgorithm.HS384, secret.getBytes())
                .compact();

    }

}
