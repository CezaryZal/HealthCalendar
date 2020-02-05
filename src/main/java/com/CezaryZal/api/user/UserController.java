package com.CezaryZal.api.user;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.manager.UpdateUser;
import com.CezaryZal.api.user.manager.UserService;
import com.CezaryZal.api.user.manager.NewAccountCreator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "User")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final UpdateUser updateUser;

    @Autowired
    public UserController(UserService userService,
                          UpdateUser updateUser) {
        this.userService = userService;
        this.updateUser = updateUser;
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

    @ApiOperation(value = "This will create new account")
    @PostMapping("/new-account")
    public ResponseEntity<String> createNewAccount(@RequestBody AccountEntity accountEntity){
        return new ResponseEntity<>(userService.createNewAccount(accountEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody AccountEntity accountEntity, @PathVariable Long id) {
        return new ResponseEntity<>(updateUser.updateByAccountEntity(accountEntity, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }

}
