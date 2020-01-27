package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.mapper.DailyLimitsConverter;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.manager.creator.UserCreator;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
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

    @Autowired
    public UpdateUser(UserRepoService userRepoService,
                      UserAuthService userAuthService,
                      DailyLimitsConverter dailyLimitsConverter,
                      UserCreator userCreator) {
        this.userRepoService = userRepoService;
        this.userAuthService = userAuthService;
        this.dailyLimitsConverter = dailyLimitsConverter;
        this.userCreator = userCreator;
    }

    public String updateByAccountEntity(AccountEntity accountEntity){
        User currentUser = userRepoService.getUserByLoginName(accountEntity.getLoginName());
        DailyLimits dailyLimits = handleDailyLimitsToUpdate(accountEntity, currentUser);
        UserAuthentication userAuthentication = handleUserAuthToUpdate(accountEntity, currentUser);

        User user = userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, dailyLimits, userAuthentication);
        userRepoService.updateUser(user);

        return "Przesłane dane dnia zostały uaktualnione w bazie danych";
    }

    private DailyLimits handleDailyLimitsToUpdate(AccountEntity accountEntity, User currentUser){
        DailyLimits dailyLimits = dailyLimitsConverter.mappingAccountEntityToDailyLimits(accountEntity);
        dailyLimits.setId(currentUser.getId());
        return dailyLimits;
    }

    private UserAuthentication handleUserAuthToUpdate(AccountEntity accountEntity, User currentUser){
        UserAuthentication userAuthentication = userAuthService.preparingEntityForSave(accountEntity);
        userAuthentication.setId(currentUser.getUserAuthentication().getId());
        return userAuthentication;
    }
}
