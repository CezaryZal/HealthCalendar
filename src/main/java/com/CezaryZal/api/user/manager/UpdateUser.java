package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.creator.UserCreator;
import com.CezaryZal.api.user.manager.mapper.AccountEntityToDailyLimitsConverter;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    private final UserAuthService userAuthService;
    private final UserService userService;
    private final AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter;
    private final UserCreator userCreator;

    @Autowired
    public UpdateUser(UserAuthService userAuthService,
                      UserService userService,
                      AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter,
                      UserCreator userCreator) {
        this.userAuthService = userAuthService;
        this.userService = userService;
        this.accountEntityToDailyLimitsConverter = accountEntityToDailyLimitsConverter;
        this.userCreator = userCreator;
    }

    public String updateByAccountEntity(AccountEntity accountEntity){
        User currentUser = userService.getUserByLoginName(accountEntity.getLoginName());
        DailyLimits dailyLimits = handleDailyLimitsToUpdate(accountEntity, currentUser);
        UserAuthentication userAuthentication = handleUserAuthToUpdate(accountEntity, currentUser);

        User user = userCreator.createUserByAccountEntityAndLimitsAndUserAuth(
                accountEntity, dailyLimits, userAuthentication);
        userService.updateUser(user);

        return "Przesłane dane dnia zostały uaktualnione w bazie danych";
    }

    private DailyLimits handleDailyLimitsToUpdate(AccountEntity accountEntity, User currentUser){
        DailyLimits dailyLimits = accountEntityToDailyLimitsConverter.mappingEntity(accountEntity);
        dailyLimits.setId(currentUser.getId());
        return dailyLimits;
    }

    private UserAuthentication handleUserAuthToUpdate(AccountEntity accountEntity, User currentUser){
        UserAuthentication userAuthentication = userAuthService.preparingEntityForSave(accountEntity);
        userAuthentication.setId(currentUser.getUserAuthentication().getId());
        return userAuthentication;
    }
}
