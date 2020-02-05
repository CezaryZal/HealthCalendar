package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.DailyLimitsConverter;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountCreator {

    private final UserAuthService userAuthService;
    private final DailyLimitsService dailyLimitsService;
    private final UserCreator userCreator;

    @Autowired
    public NewAccountCreator(UserAuthService userAuthService,
                             DailyLimitsService dailyLimitsService,
                             UserCreator userCreator) {
        this.userAuthService = userAuthService;
        this.dailyLimitsService = dailyLimitsService;
        this.userCreator = userCreator;
    }

    public User createAccountByAccountEntity(AccountEntity accountEntity){
        DailyLimits newDailyLimits = dailyLimitsService.convertAccountEntityToDailyLimits(accountEntity);
        UserAuthentication newUserAuth = userAuthService.preparingEntityForSave(accountEntity);
        return userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, newDailyLimits, newUserAuth);
    }
}
