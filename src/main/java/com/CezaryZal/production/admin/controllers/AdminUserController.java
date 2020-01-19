package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserDto;
import com.CezaryZal.api.user.manager.UserService;
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

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "This will get a `User` by id")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `UserDTO` by id")
    @GetMapping("/dto/user-id/{id}")
    public ResponseEntity<UserDto> getUserDTO(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `UserDTO`")
    @GetMapping("/dto")
    public ResponseEntity<List<UserDto>> getUsersDTO() {
        return new ResponseEntity<>(userService.getUsersDto(), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `User`, all records")
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

}
