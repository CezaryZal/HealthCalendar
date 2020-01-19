package com.CezaryZal.authentication.manager.mapper;

import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.filter.validator.Roles;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityToUserAuthConverter {

    public UserAuthentication mappingEntity(AccountEntity accountEntity){
        return new UserAuthentication(
                accountEntity.getId(),
                accountEntity.getLoginName(),
                accountEntity.getPassword(),
                true,
                Roles.USER.name(),
                "ADD"
        );
    }
}
