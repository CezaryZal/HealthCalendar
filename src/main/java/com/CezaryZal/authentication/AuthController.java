package com.CezaryZal.authentication;

import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.manager.LoginService;
import com.CezaryZal.authentication.model.AuthenticationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Authentication controller")
@RestController
public class AuthController {

    private final LoginService loginService;

    @Autowired
    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "This will get a token and user id by input login name and password")
    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> getAuthResponse(@RequestBody AuthenticationRequest inputAuthenticationRequest) {
        return new ResponseEntity<>(loginService.getAuthResponseByUserLogin(inputAuthenticationRequest), HttpStatus.OK);
    }
}
