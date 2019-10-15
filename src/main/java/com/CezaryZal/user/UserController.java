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

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return  UService.getAllUsers();
    }

    @PostMapping("/addUser")
    public boolean addUser (@RequestBody UserAllInf user){
        return UService.addUser(user);
    }

    //send "id:3", not 'userAllInfId'
    @PutMapping("/update")
    public boolean updateUser (@RequestBody UserAllInf userAllInf){
        return UService.updateUser(userAllInf);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return UService.delete(id);
    }

    @GetMapping("/userAllInf/id/{userId}")
    public UserAllInf getUserAllInf (@PathVariable int userId){
        return UService.getUserAllInfById(userId);
    }

    @GetMapping("/getAllUsersInf")
    public List<UserAllInf> getAllInf(){
        return UService.getAllUsersAllInf();
    }
}
