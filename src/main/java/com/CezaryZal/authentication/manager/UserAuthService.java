package com.CezaryZal.authentication.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.repo.UserAuthRepository;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService {

    private final UserAuthRepository userAuthRepository;
    private final UserAuthenticationConverter userAuthenticationConverter;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthRepository,
                           UserAuthenticationConverter userAuthenticationConverter,
                           PasswordEncoder passwordEncoder) {
        this.userAuthRepository = userAuthRepository;
        this.userAuthenticationConverter = userAuthenticationConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAuthentication getUserAuthByUserId(Long userId){
        return userAuthRepository.getUserAuthByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("User authentication not found by user id"));
    }

    public UserAuthentication preparingEntityForSave(AccountEntity accountEntity){
        String passwordBcrypt = passwordEncoder.encode(accountEntity.getPassword());
        accountEntity.setPassword(passwordBcrypt);
        return userAuthenticationConverter.mappingAccountEntityToUserAuth(accountEntity);
    }

    public void updatePasswordOfUserAuthByUserId(AuthenticationRequest authenticationRequest, Long userId){
        String passwordBcrypt = passwordEncoder.encode(authenticationRequest.getPassword());
        userAuthRepository.updatePasswordUserByUserId(passwordBcrypt, userId);
    }

    public List<UserAuthentication> getUsersAuth(){
        return userAuthRepository.findAll();
    }

    public Long getUserAuthId(Long userId){
        return userAuthRepository.getUserAuthIdByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("User authentication id not found by user id"));
    }
}
