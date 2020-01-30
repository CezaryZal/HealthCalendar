package com.CezaryZal.api.user.manager.creator;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.DailyLimitsConverter;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewAccountCreator {

    private final UserAuthService userAuthService;
    private final UserRepoService userRepoService;
    private final DailyLimitsConverter dailyLimitsConverter;
    private final UserCreator userCreator;

    @Autowired
    public NewAccountCreator(UserAuthService userAuthService,
                             UserRepoService userRepoService,
                             DailyLimitsConverter dailyLimitsConverter,
                             UserCreator userCreator) {
        this.userAuthService = userAuthService;
        this.userRepoService = userRepoService;
        this.dailyLimitsConverter = dailyLimitsConverter;
        this.userCreator = userCreator;
    }

    public String createAccountByAccountEntity(AccountEntity accountEntity){
        DailyLimits newDailyLimits = dailyLimitsConverter.mappingAccountEntityToDailyLimits(accountEntity);
        UserAuthentication newUserAuth = userAuthService.preparingEntityForSave(accountEntity);
        User newUser = userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, newDailyLimits, newUserAuth);
        userRepoService.addUser(newUser);

        return "Przesłane dane nowego konta zostały podzielone i zapisane w bazie danych";
    }
}
