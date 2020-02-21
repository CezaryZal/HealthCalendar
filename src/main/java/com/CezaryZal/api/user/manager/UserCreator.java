package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    User createUserByAccountEntityAndLimitsAndUserAuth(
            AccountEntity accountEntity,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication){
        return User.builder()
                .loginName(accountEntity.getLoginName())
                .nick(accountEntity.getNick())
                .email(accountEntity.getEmail())
                .phoneNumber(accountEntity.getPhoneNumber())
                .man(accountEntity.isMan())
                .birthDate(accountEntity.getBirthDate())
                .dailyLimits(dailyLimits)
                .userAuthentication(userAuthentication)
                .build();
    }

    User createUserToUpdateByAccountEntityAndLimitsAndUserAuth(
            AccountEntity accountEntity,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication,
            Long userId){
        return User.builder()
                .id(userId)
                .loginName(accountEntity.getLoginName())
                .nick(accountEntity.getNick())
                .email(accountEntity.getEmail())
                .phoneNumber(accountEntity.getPhoneNumber())
                .man(accountEntity.isMan())
                .birthDate(accountEntity.getBirthDate())
                .dailyLimits(dailyLimits)
                .userAuthentication(userAuthentication)
                .build();
    }
}
