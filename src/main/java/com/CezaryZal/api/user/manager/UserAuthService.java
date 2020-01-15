package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.entity.UserAuthentication;
import com.CezaryZal.api.user.respository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class UserAuthService {

    private UserAuthRepository userAuthR;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthR) {
        this.userAuthR = userAuthR;
    }

    public UserAuthentication findByLoginName(String loginName) throws AccountNotFoundException {
        return userAuthR.findByLoginName(loginName)
                .orElseThrow(() -> new AccountNotFoundException("User not found"));
    }
}
