package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.manager.UserService;
import com.CezaryZal.authentication.manager.UserAuthService;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin body controller")
@RestController
@RequestMapping("/admin/api/user")
public class AdminUserController {

    private final UserService userService;
    private final UserAuthService userAuthService;

    @Autowired
    public AdminUserController(UserService userService,
                               UserAuthService userAuthService) {
        this.userService = userService;
        this.userAuthService = userAuthService;
    }

    @ApiOperation(value = "This will get a basic `UserDto` by id")
    @GetMapping("/basic/{id}")
    public ResponseEntity<UserDto> getBasicUserDto(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getBasicUserDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a full `UserDTO` by id")
    @GetMapping("/full/{id}")
    public ResponseEntity<UserDto> getFullUserDTO(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserByUserId(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `UserDTO`")
    @GetMapping("/dto")
    public ResponseEntity<List<UserDto>> getUsersDTO() {
        return new ResponseEntity<>(userService.getUsersDto(), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `UserAuthentication`, all records")
    @GetMapping("/auth")
    public ResponseEntity<List<UserAuthentication>> getListUserAuth() {
        return new ResponseEntity<>(userAuthService.getUsersAuth(), HttpStatus.OK);
    }

}
