package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserToDtoConverter {

    public UserDto mappingEntity(User user) {
        return new UserDto(user.getId(),
                user.getLoginName(),
                user.getNick(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getSex(),
                user.getAge()
        );
    }

}
