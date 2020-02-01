package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.filter.validator.Roles;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationConverter {

    UserAuthentication mappingAccountEntityToUserAuth(AccountEntity accountEntity){
        return UserAuthentication.builder()
                .password(accountEntity.getPassword())
                .active(true)
                .roles(Roles.USER.name())
                .permissions("ADD")
                .build();
    }
}
