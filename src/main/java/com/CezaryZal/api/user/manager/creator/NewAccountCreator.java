package com.CezaryZal.api.user.manager.creator;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.UserService;
import com.CezaryZal.api.user.manager.mapper.AccountEntityToDailyLimitsConverter;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountCreator {

    private final DailyLimitsService dailyLimitsService;
    private final UserAuthService userAuthService;
    private final UserService userService;
    private final AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter;
    private final UserCreator userCreator;

    @Autowired
    public NewAccountCreator(DailyLimitsService dailyLimitsService,
                             UserAuthService userAuthService,
                             UserService userService,
                             AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter,
                             UserCreator userCreator) {
        this.dailyLimitsService = dailyLimitsService;
        this.userAuthService = userAuthService;
        this.userService = userService;
        this.accountEntityToDailyLimitsConverter = accountEntityToDailyLimitsConverter;
        this.userCreator = userCreator;
    }

    public String createAccountByAccountEntity(AccountEntity accountEntity){
        DailyLimits newDailyLimits = accountEntityToDailyLimitsConverter.mappingEntity(accountEntity);
        UserAuthentication newUserAuth = userAuthService.preparingEntityForSave(accountEntity);
        User newUser = userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, newDailyLimits, newUserAuth);
        userService.addUser(newUser);
        setUserIdToDailyLimits(newUser.getId(), newDailyLimits.getId());

        return "Przesłane dane nowego konta zostały podzielone i zapisane w bazie danych";
    }

    private void setUserIdToDailyLimits(Long userId, Long limitsId){
        DailyLimits limitById = dailyLimitsService.getLimitById(limitsId);
        limitById.setUserId(userId);
        dailyLimitsService.updateLimits(limitById);
    }
}
