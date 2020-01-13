package com.CezaryZal.login.service;

import com.CezaryZal.api.user.entity.UserAuthentication;
import com.CezaryZal.api.user.manager.UserAuthService;
import com.CezaryZal.authentication.builder.TokenBuilder;
import com.CezaryZal.login.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class LoginService {

    private UserAuthService userAuthS;
    private TokenBuilder tokenBuilder;

    @Autowired
    public LoginService(UserAuthService userAuthS, TokenBuilder tokenBuilder) {
        this.userAuthS = userAuthS;
        this.tokenBuilder = tokenBuilder;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
        UserAuthentication foundUserAuthentication = userAuthS.findByLoginName(inputAuthenticationRequest.getLoginName());

        return tokenBuilder.buildTokenByUser(foundUserAuthentication);
    }

}
