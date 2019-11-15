package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/body")
public class BodySizeController {

    private BodySizeService bodySizeS;

    public BodySizeController(BodySizeService bodySizeS) {
        this.bodySizeS = bodySizeS;
    }


    @GetMapping("/id/{nrId}")
    public BodySize getBodyById (@PathVariable int nrId){
        return bodySizeS.getBodyById(nrId);
    }

    @GetMapping("/byLastDate/{userId}")
    public LocalDate getDateLastMeasureByUserId(@PathVariable int userId){
        return bodySizeS.getDateLastMeasureByUserId(userId);
    }

    @GetMapping("/byUserIdAllDate/{userId}")
    public List<LocalDate> getListDatesByUserIdAllDate (@PathVariable int userId){
        return bodySizeS.getListDatesByUserIdAllDate(userId);
    }

    @GetMapping("/byDateAndUserId/{date}/{userId}")
    public BodySize getBodyByDateAndUserId (@PathVariable String date, @PathVariable int userId){
        return bodySizeS.getBodyByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<BodySize> getAll(){
        return bodySizeS.getAll();
    }

    @PostMapping("/add")
    public boolean addBody (@RequestBody BodySize bodySize){
        return bodySizeS.addBody(bodySize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBodyById (@PathVariable int id) {
        return bodySizeS.deleteBodyById(id);
    }


}
