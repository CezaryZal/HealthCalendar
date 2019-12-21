package com.CezaryZal.testDB;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @GetMapping("/hello")
    public String showHello() {
        return "Hello!? success?";
    }


    @GetMapping("/user")
    public TestEntity tmpEntity(){
        TestEntity entity = new TestEntity("Dziad", 1234);

        return entity;
    }

    @GetMapping("/authe")
    public String showAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.toString();
    }

}
