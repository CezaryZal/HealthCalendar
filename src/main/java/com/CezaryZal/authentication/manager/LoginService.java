package com.CezaryZal.authentication.manager;

import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.builder.TokenBuilder;
import com.CezaryZal.authentication.entity.AuthenticationRequest;
import com.CezaryZal.authentication.manager.filter.PasswordComparator;
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

    public String getTokenByUserLogin(AuthenticationRequest inputAuthRequest){
        UserAuthentication foundUserAuth = userAuthService.findByLoginName(inputAuthRequest.getLoginName());
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthRequest.getPassword(), foundUserAuth.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuth);
    }

}
