package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.repo.UserRepository;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    private final UserAuthService userAuthService;
    private final UserRepository userRepository;

    @Autowired
    public UpdateUser(UserAuthService userAuthService,
                      UserRepository userRepository) {
        this.userAuthService = userAuthService;
        this.userRepository = userRepository;
    }

    //method useful in the future while changing loginName
    private UserAuthentication handleUserAuthToUpdate(AccountEntity accountEntity, Long userId){
        Long userAuthId = userAuthService.getUserAuthId(userId);
        UserAuthentication userAuthentication = userAuthService.preparingEntityForSave(accountEntity);
        userAuthentication.setId(userAuthId);
        return userAuthentication;
    }

    public void updateByAccountEntity(AccountEntity accountEntity, Long userId){
        userRepository.updateUser(
                accountEntity.getNick(),
                accountEntity.getEmail(),
                accountEntity.getPhoneNumber(),
                accountEntity.isMan(),
                accountEntity.getBirthDate(),
                accountEntity.getKcalDemandPerDay(),
                accountEntity.getDrinkDemandPerDay(),
                userId);
    }

    public void updatePasswordOfUser(AuthenticationRequest authenticationRequest, Long userId){
        userAuthService.updatePasswordOfUserAuthByUserId(authenticationRequest, userId);
    }
}
