package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountCreator {

    private final UserAuthService userAuthService;
    private final UserCreator userCreator;

    @Autowired
    public NewAccountCreator(UserAuthService userAuthService,
                             UserCreator userCreator) {
        this.userAuthService = userAuthService;
        this.userCreator = userCreator;
    }

    public User createAccountByAccountEntity(AccountEntity accountEntity){
        UserAuthentication newUserAuth = userAuthService.preparingEntityForSave(accountEntity);
        return userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, newUserAuth);
    }
}
