package com.CezaryZal.user.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Controller for login")
@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "This will get a basic info about `User` by token")
    @GetMapping("/login")
    public UserBasic getBasicUserInfo(){
        return loginService.getTmpUserBasic();
    }
}
