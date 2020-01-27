package com.CezaryZal.authentication.manager.repo;

import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.UserAuthRepository;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthRepoService {

    private UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthRepoService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public UserAuthentication findByLoginName(String loginName) {
        return userAuthRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<UserAuthentication> getListUserAuth(){
        return userAuthRepository.findAll();
    }

}
