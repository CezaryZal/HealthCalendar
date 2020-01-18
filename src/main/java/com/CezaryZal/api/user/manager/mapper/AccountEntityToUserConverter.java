package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.api.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityToUserConverter {

    public User mappingEntity(AccountEntity accountEntity){
        return new User(
                accountEntity.getLoginName(),
                accountEntity.getNick(),
                accountEntity.getEmail(),
                accountEntity.getPhoneNumber(),
                accountEntity.getSex(),
                accountEntity.getBirthDate()
        );
    }
}
