package com.CezaryZal.authentication.manager.repo;

import com.CezaryZal.authentication.model.entity.UserAuthentication;
import com.CezaryZal.authentication.UserAuthRepository;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthRepoService {

    private final UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthRepoService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public List<UserAuthentication> getListUserAuth(){
        return userAuthRepository.findAll();
    }

    public Long getUserAuth(Long userId){
        return userAuthRepository.getUserAuthIdByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("Użytkownik o wpisanym id nie istnieje"));
    }

}
