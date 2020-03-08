package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    private final UserAuthService userAuthService;
    private final UserCreator userCreator;

    @Autowired
    public UpdateUser(UserAuthService userAuthService,
                      UserCreator userCreator) {
        this.userAuthService = userAuthService;
        this.userCreator = userCreator;
    }

    //method useful in the future while changing loginName
    private UserAuthentication handleUserAuthToUpdate(AccountEntity accountEntity, Long userId){
        Long userAuthId = userAuthService.getUserAuthId(userId);
        UserAuthentication userAuthentication = userAuthService.preparingEntityForSave(accountEntity);
        userAuthentication.setId(userAuthId);
        return userAuthentication;
    }

    public User updateByAccountEntity(User currentUser, AccountEntity accountEntity){
        return userCreator.createUserToUpdateByAccountEntityAndLimitsAndUserAuth(
                currentUser, accountEntity);
    }

    public void updatePasswordOfUser(AuthenticationRequest authenticationRequest, Long userId){
        userAuthService.updatePasswordOfUserAuthByUserId(authenticationRequest, userId);
    }
}
