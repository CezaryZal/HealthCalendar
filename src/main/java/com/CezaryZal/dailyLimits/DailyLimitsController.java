package com.CezaryZal.dailyLimits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limit")
public class DailyLimitsController {

    private DailyLimitsService DailyLimitsS;

    @Autowired
    public DailyLimitsController(DailyLimitsService dailyLimitsS) {
        DailyLimitsS = dailyLimitsS;
    }

    @GetMapping("/id/{nrId}")
    public DailyLimits getLimitsById (@PathVariable int nrId){
        return DailyLimitsS.getLimitsById(nrId);
    }

    @GetMapping("/byUserId/{userId}")
    public DailyLimits getLimitsByUserId (@PathVariable int userId){
        return DailyLimitsS.getLimitsByUserId(userId);
    }

    @GetMapping("/getAll")
    public List<DailyLimits> getAll(){
        return DailyLimitsS.getAll();
    }

    @PostMapping("/add")
    public boolean addLimits (@RequestBody DailyLimits dailyLimits){
        return DailyLimitsS.addLimits(dailyLimits);
    }

    @PutMapping("/update")
    public boolean updateLimits (@RequestBody DailyLimits dailyLimits){
        return DailyLimitsS.updateLimits(dailyLimits);
    }

    @DeleteMapping("/delete/{nrId}")
    public String deleteLimitsById (@PathVariable int nrId){
        return DailyLimitsS.deleteLimitsById(nrId);
    }
}
