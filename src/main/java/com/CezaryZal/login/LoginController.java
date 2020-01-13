package com.CezaryZal.login;

import com.CezaryZal.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Login controller")
@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "This will get a token by input login name and password")
    @PostMapping("/login")
    public ResponseEntity<String> getTokenByUserLogin(@RequestBody AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
        return new ResponseEntity<>(loginService.getTokenByUserLogin(inputAuthenticationRequest), HttpStatus.OK);
    }
}
