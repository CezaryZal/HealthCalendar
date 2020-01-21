package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.authentication.UserAuthRepository;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.mapper.AccountEntityToUserAuthConverter;
import com.CezaryZal.authentication.manager.repo.UserAuthRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService extends UserAuthRepoService {

    private final AccountEntityToUserAuthConverter accountEntityToUserAuthConverter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthRepository,
                           AccountEntityToUserAuthConverter accountEntityToUserAuthConverter,
                           PasswordEncoder passwordEncoder) {
        super(userAuthRepository);
        this.accountEntityToUserAuthConverter = accountEntityToUserAuthConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthentication preparingEntityForSave(AccountEntity accountEntity){
        String passwordBcrypt = passwordEncoder.encode(accountEntity.getPassword());
        accountEntity.setPassword(passwordBcrypt);
        return accountEntityToUserAuthConverter.mappingEntity(accountEntity);
    }
}
