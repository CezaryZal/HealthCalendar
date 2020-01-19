package com.CezaryZal.api.user.manager.creator;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.authentication.entity.UserAuthentication;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    public User createUserByAccountEntityAndLimitsAndUserAuth(
            AccountEntity accountEntity,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication){

        return new User(
                accountEntity.getId(),
                accountEntity.getLoginName(),
                accountEntity.getNick(),
                accountEntity.getEmail(),
                accountEntity.getPhoneNumber(),
                accountEntity.getSex(),
                accountEntity.getBirthDate(),
                dailyLimits,
                userAuthentication
        );
    }
}
