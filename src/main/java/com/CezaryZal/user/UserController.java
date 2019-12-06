package com.CezaryZal.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService UserS;

    public UserController(UserService UService) {
        this.UserS = UService;
    }

    @ApiOperation(value = "This will get a `User` by id")
    @GetMapping("/{id}")
    public User getUser (@PathVariable Long id){
        return UserS.getUserById(id);
    }

    @ApiOperation(value = "This will get a `UserDTO` by id")
    @GetMapping("/dto/user-id/{id}")
    public UserDTO getUserDTO (@PathVariable Long id){
        return UserS.getUserDTOById(id);
    }

    @ApiOperation(value = "This will get a list `UserDTO`")
    @GetMapping("/dto")
    public List<UserDTO> getUsersDTO(){
        return  UserS.getAllUsersDTO();
    }

    @ApiOperation(value = "This will get a list `User`, all records")
    @GetMapping
    public List<User> getUsers(){
        return UserS.getAllUsers();
    }

    @PostMapping
    public boolean addUser (@RequestBody User user){
        return UserS.addUser(user);
    }

    @PutMapping
    public boolean updateUser (@RequestBody User user){
        return UserS.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return UserS.deleteUserById(id);
    }

}
