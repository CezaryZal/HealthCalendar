package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/body")
public class BodySizeController {

    private BodySizeService BSService;

    @Autowired
    public BodySizeController(BodySizeService BSService) {
        this.BSService = BSService;
    }


    @GetMapping("/id/{nrId}")
    public BodySize getBodySize (@PathVariable int nrId){
        BodySize bodySize = BSService.findById(nrId);

        return bodySize;
    }

    @PostMapping("/addBody")
    public Boolean addBody (@RequestBody BodySize bodySize){

        Boolean answer = BSService.addBody(bodySize);
        return answer;
    }

//    @GetMapping("/dateAndUser/{userId}/{date}")
//    public BodySize getBodySizeByDateAndUserId (@PathVariable int userId, @PathVariable String date){
//        BodySize bodySize = bodyService.getBodySizeByDateAndUserId(userId, date);
//
//        return bodySize;
//    }
}
