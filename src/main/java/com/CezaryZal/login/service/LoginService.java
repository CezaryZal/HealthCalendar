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

    private UserAuthService userAuthService;
    private TokenBuilder tokenBuilder;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserAuthService userAuthService, TokenBuilder tokenBuilder, PasswordComparator passwordComparator) {
        this.userAuthService = userAuthService;
        this.tokenBuilder = tokenBuilder;
        this.passwordComparator = passwordComparator;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthRequest) throws AccountNotFoundException {
        UserAuthentication foundUserAuth = userAuthService.findByLoginName(inputAuthRequest.getLoginName());
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthRequest.getPassword(), foundUserAuth.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuth);
    }

}
