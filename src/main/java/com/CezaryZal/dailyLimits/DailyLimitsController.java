package com.CezaryZal.dailyLimits;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Daily Limits")
@RestController
@RequestMapping("/limits")
public class DailyLimitsController {

    private DailyLimitsService DailyLimitsS;

    public DailyLimitsController(DailyLimitsService dailyLimitsS) {
        DailyLimitsS = dailyLimitsS;
    }

    @ApiOperation(value = "This will get a `DailyLimits` by id")
    @GetMapping("/{id}")
    public ResponseEntity<DailyLimits> getLimitsById (@PathVariable Long id){
        return new ResponseEntity<>(DailyLimitsS.getLimitsById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `DailyLimits` by user id")
    @GetMapping("/user-id/{userId}")
    public ResponseEntity<DailyLimits> getLimitsByUserId (@PathVariable Long userId){
        return new ResponseEntity<>(DailyLimitsS.getLimitsByUserId(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `DailyLimits`, all records")
    @GetMapping
    public ResponseEntity<List<DailyLimits>> getAll(){
        return new ResponseEntity<>(DailyLimitsS.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addLimits (@RequestBody DailyLimits dailyLimits){
        DailyLimitsS.addLimits(dailyLimits);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> updateLimits (@RequestBody DailyLimits dailyLimits){
        DailyLimitsS.updateLimits(dailyLimits);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLimitsById (@PathVariable Long id){
        DailyLimitsS.deleteLimitsById(id);
        return ResponseEntity.noContent().build();
    }
}
