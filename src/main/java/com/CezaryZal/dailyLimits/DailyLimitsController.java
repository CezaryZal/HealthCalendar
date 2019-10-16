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
    public DailyLimits getDailyLimitsById (@PathVariable int nrId){
        return DLService.findById(nrId);
    }

    @GetMapping("/byUserId/{userId}")
    public DailyLimits dailyLimits (@PathVariable int userId){
        return DLService.findByUserId(userId);
    }

    @GetMapping("/getAll")
    public List<DailyLimits> listLimits(){
        return DLService.getAll();
    }

    @PostMapping("/add")
    public boolean addLimits (@RequestBody DailyLimits dailyLimits){
        return DLService.addDailyLimits(dailyLimits);
    }

    @PutMapping("/update")
    public boolean updateLimits (@RequestBody DailyLimits dailyLimits){
        return DLService.updateDailyLimits(dailyLimits);
    }

    @DeleteMapping("/delete/{nrId}")
    public String delete (@PathVariable int nrId){
        return DLService.delete(nrId);
    }
}
