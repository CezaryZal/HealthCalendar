package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.manager.UserService;
import com.CezaryZal.authentication.model.AuthenticationResponse;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.manager.filter.PasswordComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserService userService;
    private final TokenBuilder tokenBuilder;
    private final PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserService userService,
                        TokenBuilder tokenBuilder,
                        PasswordComparator passwordComparator) {
        this.userService = userService;
        this.tokenBuilder = tokenBuilder;
        this.passwordComparator = passwordComparator;
    }

    public AuthenticationResponse getAuthResponseByUserLogin(AuthenticationRequest inputAuthRequest) {
        ObjectToAuthResponse object = userService.getObjectToAuthResponse(inputAuthRequest.getLoginName());
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthRequest.getPassword(), object.getPassword());
        return new AuthenticationResponse(
                tokenBuilder.buildTokenByUser(inputAuthRequest.getLoginName(), object.getRoles()),
                object.getUserId());
    }

}
