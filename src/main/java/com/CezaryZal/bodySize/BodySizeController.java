package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/body")
public class BodySizeController {

    private BodySizeService BodySizeS;

    @Autowired
    public BodySizeController(BodySizeService BSService) {
        this.BodySizeS = BSService;
    }


    @GetMapping("/id/{nrId}")
    public BodySize getBodyById (@PathVariable int nrId){
        return BodySizeS.getBodyById(nrId);
    }

    @GetMapping("/byLastDate/{userId}")
    public LocalDate getDateLastMeasureByUserId(@PathVariable int userId){
        return BodySizeS.getDateLastMeasureByUserId(userId);
    }

    @GetMapping("/byUserIdAllDate/{userId}")
    public List<LocalDate> getListDatesByUserIdAllDate (@PathVariable int userId){
        return BodySizeS.getListDatesByUserIdAllDate(userId);
    }

    @GetMapping("/byDateAndUserId/{date}/{userId}")
    public BodySize getBodyByDateAndUserId (@PathVariable String date, @PathVariable int userId){
        return BodySizeS.getBodyByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<BodySize> getAll(){
        return BodySizeS.getAll();
    }

    @PostMapping("/add")
    public boolean addBody (@RequestBody BodySize bodySize){
        return BodySizeS.addBody(bodySize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBodyById (@PathVariable int id) {
        return BodySizeS.deleteBodyById(id);
    }


}
