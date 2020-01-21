package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public User mappingAccountEntityToUser(AccountEntity accountEntity){
        return new User(
                accountEntity.getLoginName(),
                accountEntity.getNick(),
                accountEntity.getEmail(),
                accountEntity.getPhoneNumber(),
                accountEntity.getSex(),
                accountEntity.getBirthDate()
        );
    }

    public UserDto mappingUserToDto(User user) {
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
