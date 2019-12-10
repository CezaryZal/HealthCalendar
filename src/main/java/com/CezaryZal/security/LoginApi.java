package com.CezaryZal.security;

import com.CezaryZal.user.UserToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/login")
    public String getLog (@RequestBody UserToken userToken){
        long currentTimeMillis = System.currentTimeMillis();

        return Jwts
                .builder()
                .setSubject(userToken.getLogin())
                .claim("roles", "ADMIN")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 30000))
                .signWith(SignatureAlgorithm.HS384, userToken.getPassword())
                .compact();

    }
}
