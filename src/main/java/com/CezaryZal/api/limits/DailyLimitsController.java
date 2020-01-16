package com.CezaryZal.api.limits;

import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Daily Limits")
@RestController
@RequestMapping("/api/limits")
public class DailyLimitsController {

    private DailyLimitsService dailyLimitsS;

    @Autowired
    public DailyLimitsController(DailyLimitsService dailyLimitsS) {
        this.dailyLimitsS = dailyLimitsS;
    }

    @ApiOperation(value = "This will get a `DailyLimits` by id")
    @GetMapping("/{id}")
    public ResponseEntity<DailyLimitsDto> getLimitsDtoById (@PathVariable Long id){
        return new ResponseEntity<>(dailyLimitsS.getLimitsDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `DailyLimits` by user id")
    @GetMapping("/user-id/{userId}")
    public ResponseEntity<DailyLimitsDto> getLimitsDtoByUserId (@PathVariable Long userId){
        return new ResponseEntity<>(dailyLimitsS.getLimitsDtoByUserId(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint input `DailyLimits` object update ")
    @PutMapping
    public ResponseEntity<String> updateLimits (@RequestBody DailyLimitsDto dailyLimitsDto){
        return new ResponseEntity<>(dailyLimitsS.updateDailyLimits(dailyLimitsDto), HttpStatus.OK);
    }

}
