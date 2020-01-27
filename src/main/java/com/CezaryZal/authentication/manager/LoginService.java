package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.AuthenticationResponse;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.builder.TokenBuilder;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.manager.filter.PasswordComparator;
import com.CezaryZal.authentication.manager.repo.UserAuthRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserAuthRepoService userAuthRepoService;
    private final UserRepoService userRepoService;
    private TokenBuilder tokenBuilder;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserAuthRepoService userAuthRepoService, UserRepoService userRepoService,
                        TokenBuilder tokenBuilder, PasswordComparator passwordComparator) {
        this.userAuthRepoService = userAuthRepoService;
        this.userRepoService = userRepoService;
        this.tokenBuilder = tokenBuilder;
        this.passwordComparator = passwordComparator;
    }

    public AuthenticationResponse getAuthResponseByUserLogin(AuthenticationRequest inputAuthRequest){
        UserAuthentication foundUserAuth = userAuthRepoService.findByLoginName(inputAuthRequest.getLoginName());
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthRequest.getPassword(), foundUserAuth.getPassword());
        Long userId = userRepoService.getIdByLoginName(inputAuthRequest.getLoginName());
        return new AuthenticationResponse(tokenBuilder.buildTokenByUser(foundUserAuth), userId);
    }

}
