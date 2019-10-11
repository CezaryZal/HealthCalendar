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

        return UService.findById(userId);
    }



    @PostMapping("/addUser")
    public boolean addUser (@RequestBody User user){
        return UService.addUser(user);
    }
}
