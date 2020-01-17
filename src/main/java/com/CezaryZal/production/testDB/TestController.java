package com.CezaryZal.production.testDB;


//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import com.CezaryZal.api.user.entity.UserCreator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @GetMapping("/non/hello")
    public String showHello() {
        return "Hello!? success?";
    }

    @PostMapping("/non/login")
    public String getLoginByUserCreator(@RequestBody UserCreator userCreator){
        return userCreator.getLoginName();
    }

//    @GetMapping("/authe")
//    public String showAuthentication(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.toString();
//    }

}
