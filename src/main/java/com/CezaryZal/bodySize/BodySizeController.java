package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/byDateAndUserId/{date}/{userId}")
    public BodySize findByDateAndUserId (@PathVariable String date, @PathVariable int userId){
        BodySize bodySize = BSService.findByDateAndUserId(date, userId);

        return bodySize;
    }

    @GetMapping("/getAll")
    public List<BodySize> getAll(){
        return BSService.getAll();
    }

    @PostMapping("/addBody")
    public boolean addBody (@RequestBody BodySize bodySize){

        boolean answer = BSService.addBody(bodySize);
        return answer;
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id) {
        return BSService.delete(id);
    }


}
