package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.DailyLimitsConverter;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.manager.creator.UserCreator;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.authentication.manager.repo.UserAuthRepoService;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    private final UserRepoService userRepoService;
    private final UserAuthService userAuthService;
    private final DailyLimitsConverter dailyLimitsConverter;
    private final UserCreator userCreator;
    private final UserAuthRepoService userAuthRepoService;
    private final DailyLimitsService dailyLimitsService;

    @Autowired
    public UpdateUser(UserRepoService userRepoService,
                      UserAuthService userAuthService,
                      DailyLimitsConverter dailyLimitsConverter,
                      UserCreator userCreator,
                      UserAuthRepoService userAuthRepoService,
                      DailyLimitsService dailyLimitsService) {
        this.userRepoService = userRepoService;
        this.userAuthService = userAuthService;
        this.dailyLimitsConverter = dailyLimitsConverter;
        this.userCreator = userCreator;
        this.userAuthRepoService = userAuthRepoService;
        this.dailyLimitsService = dailyLimitsService;
    }

    public String updateByAccountEntity(AccountEntity accountEntity, Long userId){
        DailyLimits dailyLimits = handleDailyLimitsToUpdate(accountEntity, userId);
        UserAuthentication userAuthentication = handleUserAuthToUpdate(accountEntity, userId);
        User user = userCreator.createUserToUpdateByAccountEntityAndLimitsAndUserAuth(
                accountEntity, dailyLimits, userAuthentication, userId);
        userRepoService.updateUser(user);

        return "Przesłane dane dnia zostały uaktualnione w bazie danych";
    }

    private DailyLimits handleDailyLimitsToUpdate(AccountEntity accountEntity, Long userId){
        Long limitsId = dailyLimitsService.getLimitsId(userId);
        DailyLimits dailyLimits = dailyLimitsConverter.mappingAccountEntityToDailyLimits(accountEntity);
        dailyLimits.setId(limitsId);
        return dailyLimits;
    }

    private UserAuthentication handleUserAuthToUpdate(AccountEntity accountEntity, Long userId){
        Long userAuthId = userAuthRepoService.getUserAuth(userId);
        UserAuthentication userAuthentication = userAuthService.preparingEntityForSave(accountEntity);
        userAuthentication.setId(userAuthId);
        return userAuthentication;
    }
}
