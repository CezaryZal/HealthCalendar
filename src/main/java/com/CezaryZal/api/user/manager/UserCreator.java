package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {

    User createUserByAccountEntityAndLimitsAndUserAuth(
            AccountEntity accountEntity,
            UserAuthentication userAuthentication){
        return User.builder()
                .loginName(accountEntity.getLoginName())
                .nick(accountEntity.getNick())
                .email(accountEntity.getEmail())
                .phoneNumber(accountEntity.getPhoneNumber())
                .man(accountEntity.isMan())
                .birthDate(accountEntity.getBirthDate())
                .kcalDemandPerDay(accountEntity.getKcalDemandPerDay())
                .drinkDemandPerDay(accountEntity.getDrinkDemandPerDay())
                .userAuthentication(userAuthentication)
                .build();
    }

    User createUserToUpdateByAccountEntityAndLimitsAndUserAuth(User currentUser, AccountEntity accountEntity){
        return User.builder()
                .id(currentUser.getId())
                .loginName(accountEntity.getLoginName())
                .nick(accountEntity.getNick())
                .email(accountEntity.getEmail())
                .phoneNumber(accountEntity.getPhoneNumber())
                .man(accountEntity.isMan())
                .birthDate(accountEntity.getBirthDate())
                .kcalDemandPerDay(accountEntity.getKcalDemandPerDay())
                .drinkDemandPerDay(accountEntity.getDrinkDemandPerDay())
                .userAuthentication(currentUser.getUserAuthentication())
                .listMeasureByBodySize(currentUser.getListMeasureByBodySize())
                .listDays(currentUser.getListDays())
                .build();
    }
}
