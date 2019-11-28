package com.CezaryZal.dailyLimits;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/limit")
public class DailyLimitsController {

    private DailyLimitsService DailyLimitsS;

    public DailyLimitsController(DailyLimitsService dailyLimitsS) {
        DailyLimitsS = dailyLimitsS;
    }

    @GetMapping("/id/{id}")
    public DailyLimits getLimitsById (@PathVariable Long id){
        return DailyLimitsS.getLimitsById(id);
    }

    @GetMapping("/byUserId/{userId}")
    public DailyLimits getLimitsByUserId (@PathVariable Long userId){
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

    @DeleteMapping("/delete/{id}")
    public String deleteLimitsById (@PathVariable Long id){
        return DailyLimitsS.deleteLimitsById(id);
    }
}
