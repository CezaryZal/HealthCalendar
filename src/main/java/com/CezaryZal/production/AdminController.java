package com.CezaryZal.production;

import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.meal.entity.MealDto;
import com.CezaryZal.api.meal.manager.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin controller")
@RestController
@RequestMapping("/admin/api")
public class AdminController {

    private final BodySizeService bodySizeService;
    private final DailyLimitsService dailyLimitsService;
    private final MealService mealService;

    @Autowired
    public AdminController(BodySizeService bodySizeService,
                           DailyLimitsService dailyLimitsService,
                           MealService mealService) {
        this.bodySizeService = bodySizeService;
        this.dailyLimitsService = dailyLimitsService;
        this.mealService = mealService;
    }

    @ApiOperation(value = "This will get a list `BodySize`, all records")
    @GetMapping("/bodies")
    public ResponseEntity<List<BodySizeDto>> getListBodySizeDto() {
        return new ResponseEntity<>(bodySizeService.getListBodySizeDto(), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint input `BodySize` object update ")
    @PutMapping("/body")
    public ResponseEntity<String> updateBodySizeByDao(@RequestBody BodySizeDto bodySizeDto) {
        return new ResponseEntity<>(bodySizeService.updateBodySizeByDao(bodySizeDto), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `DailyLimits`, all records")
    @GetMapping("/limits")
    public ResponseEntity<List<DailyLimitsDto>> getListLimitsDto(){
        return new ResponseEntity<>(dailyLimitsService.getListLimitsDto(), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint addition `DailyLimits`")
    @PostMapping("/limits")
    public ResponseEntity<String> addLimits (@RequestBody DailyLimitsDto dailyLimitsDto){
        return new ResponseEntity<>(dailyLimitsService.addDailyLimits(dailyLimitsDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "This endpoint remove `DailyLimits` by id")
    @DeleteMapping("/limits/{id}")
    public ResponseEntity<String> deleteLimitsById (@PathVariable Long id){
        return new ResponseEntity<>(dailyLimitsService.deleteDailyLimitsById(id), HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "This will get a `Meal` by id")
    @GetMapping("/meal/{id}")
    public ResponseEntity<MealDto> getMealDtoById (@PathVariable Long id){
        return new ResponseEntity<>(mealService.getMealDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Meal`, all records")
    @GetMapping("/meals")
    public ResponseEntity<List<MealDto>> getListMealDto(){
        return new ResponseEntity<>(mealService.getListMealDto(), HttpStatus.OK);
    }

}
