package com.CezaryZal.testDB;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
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

}
