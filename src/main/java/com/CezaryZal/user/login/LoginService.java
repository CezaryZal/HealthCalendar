package com.CezaryZal.user.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {



    public UserBasic getTmpUserBasic(){
        return new UserBasic(1L, "nick", "ktos");
    }
}
