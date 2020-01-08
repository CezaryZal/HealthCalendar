package com.CezaryZal.api.user;

import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserCreator;
import com.CezaryZal.api.user.entity.UserDTO;
import com.CezaryZal.api.user.manager.NewAccountAdder;
import com.CezaryZal.api.user.manager.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "User")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userS;
    private NewAccountAdder newAccountAdder;

    @Autowired
    public UserController(UserService userS, NewAccountAdder newAccountAdder) {
        this.userS = userS;
        this.newAccountAdder = newAccountAdder;
    }

    @ApiOperation(value = "This will get a `User` by id")
    @GetMapping("/{id}")
    public User getUser (@PathVariable Long id){
        return userS.getUserById(id);
    }

    @ApiOperation(value = "This will get a `UserDTO` by id")
    @GetMapping("/dto/user-id/{id}")
    public UserDTO getUserDTO (@PathVariable Long id){
        return userS.getUserDTOById(id);
    }

    @ApiOperation(value = "This will get a `User` by login name")
    @GetMapping("/login-name/{loginName}")
    public User getUserByLoginName(@PathVariable String loginName){
        return  userS.getUserByLoginName(loginName);
    }

    @GetMapping("/user-id/login-name/{loginName}")
    public Long getUserIdByLoginName(@PathVariable String loginName){
        return userS.getUserIdByLoginName(loginName);
    }

    @ApiOperation(value = "This will get a list `UserDTO`")
    @GetMapping("/dto")
    public List<UserDTO> getUsersDTO(){
        return  userS.getAllUsersDTO();
    }

    @ApiOperation(value = "This will get a list `User`, all records")
    @GetMapping
    public List<User> getUsers(){
        return userS.getAllUsers();
    }

    @PostMapping
    public boolean addUser (@RequestBody User user){
        return userS.addUser(user);
    }


    @PutMapping
    public boolean updateUser (@RequestBody User user){
        return userS.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return userS.deleteUserById(id);
    }

}
