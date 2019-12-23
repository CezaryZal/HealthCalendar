package com.CezaryZal.login;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Controller for login")
@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "This will get a basic info about `User` by token")
    @GetMapping("/login/{loginName}")
    public UserBasic getBasicUserInfo(@PathVariable String loginName){
        return loginService.getUserBasicFromUser(loginName);
    }
}
