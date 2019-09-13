package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public User getUser(){
        User user = new User("Tom", "tomy", "tomy@gmail.com", 458658356,
                "tomek", "test", 0);
        return user;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/listUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser (@PathVariable int id){

        User tmpUser = userService.getUser(id);

        return tmpUser;
    }
}
