package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        return BSService.findById(nrId);
    }

    @GetMapping("/byUserIdAllDate/{userId}")
    public List<LocalDate> findByUserIdAllDate (@PathVariable int userId){
        return BSService.findByUserIdAllDate(userId);
    }

    @GetMapping("/byDateAndUserId/{date}/{userId}")
    public BodySize findByDateAndUserId (@PathVariable String date, @PathVariable int userId){
        return BSService.findByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<BodySize> getAll(){
        return BSService.getAll();
    }

    @PostMapping("/addBody")
    public boolean addBody (@RequestBody BodySize bodySize){
        return BSService.addBody(bodySize);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id) {
        return BSService.delete(id);
    }


}
