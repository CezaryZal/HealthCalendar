package com.CezaryZal.authentication.manager.mapper;

import com.CezaryZal.authentication.entity.EntityForNewUserAuth;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.filter.validator.Roles;
import org.springframework.stereotype.Service;

@Service
public class AuthEntityToUserAuth {

    public UserAuthentication mappingEntity(EntityForNewUserAuth authEntity){
        return new UserAuthentication(
                null,
                authEntity.getLoginName(),
                authEntity.getPassword(),
                true,
                Roles.USER.name(),
                "ADD"
        );
    }
}
