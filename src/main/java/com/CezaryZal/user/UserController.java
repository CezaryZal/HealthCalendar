//package com.CezaryZal.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/listUsers")
//    public List<User> getUsers(){
//        return userService.getUsers();
//    }
//
//    @GetMapping("/id/{userId}")
//    public User getUser (@PathVariable int userId){
//        User user = userService.getUser(userId);
//
//        return user;
//    }
//}
