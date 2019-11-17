package com.CezaryZal.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService UserS;

    public UserController(UserService UService) {
        this.UserS = UService;
    }

    @GetMapping("/DTOId/{userId}")
    public UserDTO getUserDTO (@PathVariable int userId){
        return UserS.getUserDTOById(userId);
    }

    @GetMapping("/UsersDTO")
    public List<UserDTO> getUsersDTO(){
        return  UserS.getAllUsersDTO();
    }

    @GetMapping("/id/{userId}")
    public User getUser (@PathVariable int userId){
        return UserS.getUserById(userId);
    }

    @GetMapping("/getAll")
    public List<User> getUsers(){
        return UserS.getAllUsers();
    }

    @PostMapping("/add")
    public boolean addUser (@RequestBody User user){
        return UserS.addUser(user);
    }

    //send "id:3", not 'userAllInfId'
    @PutMapping("/update")
    public boolean updateUser (@RequestBody User user){
        return UserS.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public String delete (@PathVariable int userId){
        return UserS.deleteUserById(userId);
    }

}
