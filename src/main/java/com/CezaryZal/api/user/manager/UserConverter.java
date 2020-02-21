package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    UserDto mappingUserToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .loginName(user.getLoginName())
                .nick(user.getNick())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .man(user.isMan())
                .age(user.getAge())
                .birthDate(user.getBirthDate())
                .kcalDemandPerDay(user.getKcalDemandPerDay())
                .drinkDemandPerDay(user.getDrinkDemandPerDay())
                .build();
    }
}
