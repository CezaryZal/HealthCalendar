package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public UserDto mappingUserToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .loginName(user.getLoginName())
                .nick(user.getNick())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .sex(user.getSex())
                .age(user.getAge())
                .build();
    }
}
