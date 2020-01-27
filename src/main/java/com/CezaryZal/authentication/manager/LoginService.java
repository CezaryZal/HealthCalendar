package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.authentication.model.AuthenticationResponse;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import com.CezaryZal.authentication.manager.builder.TokenBuilder;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.manager.filter.PasswordComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepoService userRepoService;
    private TokenBuilder tokenBuilder;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserRepoService userRepoService,
                        TokenBuilder tokenBuilder, PasswordComparator passwordComparator) {
        this.userRepoService = userRepoService;
        this.tokenBuilder = tokenBuilder;
        this.passwordComparator = passwordComparator;
    }

    public AuthenticationResponse getAuthResponseByUserLogin(AuthenticationRequest inputAuthRequest) {
        ObjectToAuthResponse object = userRepoService.getObjectToAuthResponse(inputAuthRequest.getLoginName());
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthRequest.getPassword(), object.getPassword());
        return new AuthenticationResponse(
                tokenBuilder.buildTokenByUser(inputAuthRequest.getLoginName(), object.getRoles()),
                object.getUserId());
    }

}
