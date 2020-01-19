package com.CezaryZal.api.user.manager.creator;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.UserService;
import com.CezaryZal.api.user.manager.mapper.AccountEntityToDailyLimitsConverter;
import com.CezaryZal.api.user.manager.mapper.AccountEntityToEntityForNewUserAuthConverter;
import com.CezaryZal.api.user.manager.mapper.AccountEntityToUserConverter;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreator {

    private final DailyLimitsService dailyLimitsService;
    private final UserAuthService userAuthService;
    private final UserService userService;
    private final AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter;
    private final AccountEntityToEntityForNewUserAuthConverter accountEntityToEntityForNewUserAuthConverter;
    private final AccountEntityToUserConverter accountEntityToUserConverter;

    @Autowired
    public AccountCreator(DailyLimitsService dailyLimitsService,
                          UserAuthService userAuthService,
                          UserService userService,
                          AccountEntityToDailyLimitsConverter accountEntityToDailyLimitsConverter,
                          AccountEntityToEntityForNewUserAuthConverter accountEntityToEntityForNewUserAuthConverter,
                          AccountEntityToUserConverter accountEntityToUserConverter) {
        this.dailyLimitsService = dailyLimitsService;
        this.userAuthService = userAuthService;
        this.userService = userService;
        this.accountEntityToDailyLimitsConverter = accountEntityToDailyLimitsConverter;
        this.accountEntityToEntityForNewUserAuthConverter = accountEntityToEntityForNewUserAuthConverter;
        this.accountEntityToUserConverter = accountEntityToUserConverter;
    }

    public String createNewAccountByAccountEntity(AccountEntity accountEntity){
        DailyLimits newDailyLimits = accountEntityToDailyLimitsConverter.mappingEntity(accountEntity);
        UserAuthentication newUserAuth = createUserAuthByAccountEntity(accountEntity);
        User newUser = createUserByAccountEntityAndIds(
                accountEntity, newDailyLimits, newUserAuth);
        setUserIdToDailyLimits(newUser.getId(), newDailyLimits.getId());

        return "Przesłane dane nowego konta zostały podzielone i zapisane w bazie danych";
    }

    private UserAuthentication createUserAuthByAccountEntity(AccountEntity accountEntity){
        return userAuthService.preparingEntityForSave(
                accountEntityToEntityForNewUserAuthConverter.mappingEntity(accountEntity)
        );
    }

    private User createUserByAccountEntityAndIds(
            AccountEntity accountEntity,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication){
        User newUser = accountEntityToUserConverter.mappingEntity(accountEntity);
        newUser.setDailyLimits(dailyLimits);
        newUser.setUserAuthentication(userAuthentication);
        return userService.addUser(newUser);
    }

    private void setUserIdToDailyLimits(Long userId, Long limitsId){
        DailyLimits limitById = dailyLimitsService.getLimitById(limitsId);
        limitById.setUserId(userId);
        dailyLimitsService.updateLimits(limitById);
    }

//    private void creteAccount(UserCreator userCreator){
//        userS.addUser(converter.convertUserCreatorToUser(userCreator));
//    }

//    private void updateDailyLimitsByUser(User userFromDb){
//        Long userId = userFromDb.getId();
//        DailyLimits tmpDailyLimits = userFromDb.getDailyLimits();
//        tmpDailyLimits.setUserId(userId);
//        dailyLimitsS.updateLimits(tmpDailyLimits);
//    }



}
