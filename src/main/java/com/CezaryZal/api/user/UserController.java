package com.CezaryZal.api.user;

import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserDto;
import com.CezaryZal.api.user.manager.NewAccountAdder;
import com.CezaryZal.api.user.manager.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "User")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "This will get a `User` by login name")
    @GetMapping("/login-name/{loginName}")
    public ResponseEntity<UserDto> getUserByLoginName(@PathVariable String loginName){
        return new ResponseEntity<>(userService.getUserDtoByLoginName(loginName), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get number userId by login name")
    @GetMapping("/user-id/login-name/{loginName}")
    public ResponseEntity<Long> getUserIdByLoginName(@PathVariable String loginName){
        return new ResponseEntity<>(userService.getIdByLoginName(loginName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addNewUser(user), HttpStatus.CREATED);
    }

//    @PostMapping("/user-id/new-account")
//    public Long createNewAccountAndGetHimUserId(@RequestBody UserCreator userCreator){
//        return newAccountAdder.createNewAccountAndGetHimUserId(userCreator);
//    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUserBy(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }

}
