package com.CezaryZal.api.user.manager.creator;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.repo.DailyLimitsRepoService;
import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.mapper.AccountEntityToDailyLimitsConverter;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountCreator {

    private final DailyLimitsRepoService dailyLimitsRepoService;
    private final UserAuthService userAuthService;
    private final UserRepoService userRepoService;
    private final AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter;
    private final UserCreator userCreator;

    @Autowired
    public NewAccountCreator(DailyLimitsRepoService dailyLimitsRepoService,
                             UserAuthService userAuthService,
                             UserRepoService userRepoService,
                             AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter,
                             UserCreator userCreator) {
        this.dailyLimitsRepoService = dailyLimitsRepoService;
        this.userAuthService = userAuthService;
        this.userRepoService = userRepoService;
        this.accountEntityToDailyLimitsConverter = accountEntityToDailyLimitsConverter;
        this.userCreator = userCreator;
    }

    public String createAccountByAccountEntity(AccountEntity accountEntity){
        DailyLimits newDailyLimits = accountEntityToDailyLimitsConverter.mappingEntity(accountEntity);
        UserAuthentication newUserAuth = userAuthService.preparingEntityForSave(accountEntity);
        User newUser = userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, newDailyLimits, newUserAuth);
        userRepoService.addUser(newUser);
        setUserIdToDailyLimits(newUser.getId(), newDailyLimits.getId());

        return "Przesłane dane nowego konta zostały podzielone i zapisane w bazie danych";
    }

    private void setUserIdToDailyLimits(Long userId, Long limitsId){
        DailyLimits limitById = dailyLimitsRepoService.getLimitById(limitsId);
        limitById.setUserId(userId);
        dailyLimitsRepoService.updateLimits(limitById);
    }
}
