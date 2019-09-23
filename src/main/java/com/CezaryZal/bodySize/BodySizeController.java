package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
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
}
