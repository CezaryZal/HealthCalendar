package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService UService;

    @Autowired
    public UserController(UserService UService) {
        this.UService = UService;
    }

    @GetMapping("/id/{userId}")
    public User getUser (@PathVariable int userId){
        return UService.getUserById(userId);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return  UService.getAllUsers();
    }

    @PostMapping("/addUser")
    public boolean addUser (@RequestBody UserDB user){
        return UService.addUser(user);
    }

    //send "id:3", not 'userAllInfId'
    @PutMapping("/update")
    public boolean updateUser (@RequestBody UserDB userDB){
        return UService.updateUser(userDB);
    }

    @DeleteMapping("/delete/{userId}")
    public String delete (@PathVariable int userId){
        return UService.deleteUserById(userId);
    }

    @GetMapping("/userDB/id/{userId}")
    public UserDB getUserAllInf (@PathVariable int userId){
        return UService.getUserDBById(userId);
    }

    @GetMapping("/getAllUsersInf")
    public List<UserDB> getAllInf(){
        return UService.getAllUsersDB();
    }
}
