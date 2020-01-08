package com.CezaryZal.login;

import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserService userService;

    @Autowired
    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public UserBasic getUserBasicFromUser(String loginName){
        return convertToUserBasic(getUserByLoginName(loginName));
    }


    private User getUserByLoginName(String loginName){
        return userService.getUserByLoginName(loginName);
    }

    private UserBasic convertToUserBasic(User userFromDb){
        return new UserBasic(userFromDb.getId(), userFromDb.getNick(),userFromDb.getLoginName());
    }
}
