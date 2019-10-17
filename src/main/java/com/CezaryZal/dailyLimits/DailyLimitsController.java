package com.CezaryZal.dailyLimits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/limit")
public class DailyLimitsController {

    private DailyLimitsService DLService;

    @Autowired
    public DailyLimitsController(DailyLimitsService DLService) {
        this.DLService = DLService;
    }

    @GetMapping("/id/{nrId}")
    public DailyLimits getLimitsById (@PathVariable int nrId){
        return DLService.getLimitsById(nrId);
    }

    @GetMapping("/byUserId/{userId}")
    public DailyLimits getLimitsByUserId (@PathVariable int userId){
        return DLService.getLimitsByUserId(userId);
    }

    @GetMapping("/getAll")
    public List<DailyLimits> getAll(){
        return DLService.getAll();
    }

    @PostMapping("/add")
    public boolean addLimits (@RequestBody DailyLimits dailyLimits){
        return DLService.addLimits(dailyLimits);
    }

    @PutMapping("/update")
    public boolean updateLimits (@RequestBody DailyLimits dailyLimits){
        return DLService.updateLimits(dailyLimits);
    }

    @DeleteMapping("/delete/{nrId}")
    public String deleteLimitsById (@PathVariable int nrId){
        return DLService.deleteLimitsById(nrId);
    }
}
