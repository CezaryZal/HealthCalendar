package com.CezaryZal.authentication.manager;

import com.CezaryZal.authentication.UserAuthRepository;
import com.CezaryZal.authentication.entity.EntityForNewUserAuth;
import com.CezaryZal.authentication.entity.UserAuthentication;
import com.CezaryZal.authentication.manager.mapper.AuthEntityToUserAuth;
import com.CezaryZal.authentication.manager.repo.UserAuthRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService extends UserAuthRepoService {

    private final AuthEntityToUserAuth authEntityToUserAuth;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthRepository,
                           AuthEntityToUserAuth authEntityToUserAuth,
                           PasswordEncoder passwordEncoder) {
        super(userAuthRepository);
        this.authEntityToUserAuth = authEntityToUserAuth;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthentication preparingEntityForSave(EntityForNewUserAuth authEntity){
        String passwordBcrypt = passwordEncoder.encode(authEntity.getPassword());
        authEntity.setPassword(passwordBcrypt);
        return authEntityToUserAuth.mappingEntity(authEntity);
    }
}
