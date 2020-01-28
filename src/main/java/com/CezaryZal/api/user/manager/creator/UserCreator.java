package com.CezaryZal.api.user.manager.creator;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    public User createUserByAccountEntityAndLimitsAndUserAuth(
            AccountEntity accountEntity,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication){
        return User.Builder.builder()
                .loginName(accountEntity.getLoginName())
                .nick(accountEntity.getNick())
                .email(accountEntity.getEmail())
                .phoneNumber(accountEntity.getPhoneNumber())
                .sex(accountEntity.getSex())
                .birthDate(accountEntity.getBirthDate())
                .dailyLimits(dailyLimits)
                .userAuthentication(userAuthentication)
                .build();
    }

    public User createUserToUpdateByAccountEntityAndLimitsAndUserAuth(
            AccountEntity accountEntity,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication){
        return User.Builder.builder()
                .id(accountEntity.getId())
                .loginName(accountEntity.getLoginName())
                .nick(accountEntity.getNick())
                .email(accountEntity.getEmail())
                .phoneNumber(accountEntity.getPhoneNumber())
                .sex(accountEntity.getSex())
                .birthDate(accountEntity.getBirthDate())
                .dailyLimits(dailyLimits)
                .userAuthentication(userAuthentication)
                .build();
    }
}
