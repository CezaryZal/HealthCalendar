package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/body")
public class BodySizeController {

    private BodySizeService bodyService;

    @Autowired
    public BodySizeController(BodySizeService bodyService) {
        this.bodyService = bodyService;
    }

    @GetMapping("/id/{bodyId}")
    public BodySize getBodySize (@PathVariable int bodyId){
        BodySize bodySize = bodyService.bodySize(bodyId);

        return bodySize;
    }
}
