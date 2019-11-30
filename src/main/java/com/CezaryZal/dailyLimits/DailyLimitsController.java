package com.CezaryZal.dailyLimits;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DailyLimits> getLimitsById (@PathVariable Long id){
        return new ResponseEntity<>(DailyLimitsS.getLimitsById(id), HttpStatus.OK);
    }

    @GetMapping("/byUserId/{userId}")
    public ResponseEntity<DailyLimits> getLimitsByUserId (@PathVariable Long userId){
        return new ResponseEntity<>(DailyLimitsS.getLimitsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DailyLimits>> getAll(){
        return new ResponseEntity<>(DailyLimitsS.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addLimits (@RequestBody DailyLimits dailyLimits){
        DailyLimitsS.addLimits(dailyLimits);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateLimits (@RequestBody DailyLimits dailyLimits){
        DailyLimitsS.updateLimits(dailyLimits);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLimitsById (@PathVariable Long id){
        DailyLimitsS.deleteLimitsById(id);
        return ResponseEntity.noContent().build();
    }
}
