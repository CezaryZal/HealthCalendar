package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService UserS;

    @Autowired
    public UserController(UserService UService) {
        this.UserS = UService;
    }

    @GetMapping("/id/{userId}")
    public User getUser (@PathVariable int userId){
        return UserS.getUserById(userId);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return  UserS.getAllUsers();
    }

    @PostMapping("/addUser")
    public boolean addUser (@RequestBody UserDB user){
        return UserS.addUser(user);
    }

    //send "id:3", not 'userAllInfId'
    @PutMapping("/update")
    public boolean updateUser (@RequestBody UserDB userDB){
        return UserS.updateUser(userDB);
    }

    @DeleteMapping("/delete/{userId}")
    public String delete (@PathVariable int userId){
        return UserS.deleteUserById(userId);
    }

    @GetMapping("/userDB/id/{userId}")
    public UserDB getUserAllInf (@PathVariable int userId){
        return UserS.getUserDBById(userId);
    }

    @GetMapping("/getAllUsersInf")
    public List<UserDB> getAllInf(){
        return UserS.getAllUsersDB();
    }
}
