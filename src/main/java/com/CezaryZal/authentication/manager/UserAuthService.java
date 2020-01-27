package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.mapper.UserAuthenticationConverter;
import com.CezaryZal.authentication.manager.repo.UserAuthRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService {

    private final UserAuthRepoService userAuthRepoService;
    private final UserAuthenticationConverter userAuthenticationConverter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthService(UserAuthRepoService userAuthRepoService,
                           UserAuthenticationConverter userAuthenticationConverter,
                           PasswordEncoder passwordEncoder) {
        this.userAuthRepoService = userAuthRepoService;
        this.userAuthenticationConverter = userAuthenticationConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthentication preparingEntityForSave(AccountEntity accountEntity){
        String passwordBcrypt = passwordEncoder.encode(accountEntity.getPassword());
        accountEntity.setPassword(passwordBcrypt);
        return userAuthenticationConverter.mappingAccountEntityToUserAuth(accountEntity);
    }

    public List<UserAuthentication> getUsersAuth(){
        return userAuthRepoService.getListUserAuth();
    }
}
