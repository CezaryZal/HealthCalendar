package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.user.entity.AccountEntity;
import com.CezaryZal.authentication.entity.EntityForNewUserAuth;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityToEntityForNewUserAuthConverter {

    public EntityForNewUserAuth mappingEntity(AccountEntity accountEntity){
        return new EntityForNewUserAuth(
                accountEntity.getLoginName(),
                accountEntity.getPassword(),
                accountEntity.getPermissions()
        );
    }
}
