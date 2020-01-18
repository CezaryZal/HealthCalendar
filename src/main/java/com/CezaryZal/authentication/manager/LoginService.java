package com.CezaryZal.authentication.manager;

import com.CezaryZal.authentication.UserAuthRepository;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.builder.TokenBuilder;
import com.CezaryZal.authentication.entity.AuthenticationRequest;
import com.CezaryZal.authentication.manager.filter.PasswordComparator;
import com.CezaryZal.authentication.manager.repo.UserAuthRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends UserAuthRepoService{

    private TokenBuilder tokenBuilder;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserAuthRepository userAuthRepository,
                        TokenBuilder tokenBuilder,
                        PasswordComparator passwordComparator) {
        super(userAuthRepository);
        this.tokenBuilder = tokenBuilder;
        this.passwordComparator = passwordComparator;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthRequest){
        UserAuthentication foundUserAuth = findByLoginName(inputAuthRequest.getLoginName());
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthRequest.getPassword(), foundUserAuth.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuth);
    }

}
