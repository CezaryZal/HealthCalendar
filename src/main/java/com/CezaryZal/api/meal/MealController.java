package com.CezaryZal.api.meal;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.manager.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Meal")
@RestController
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @ApiOperation(value = "This will get a `DailyDietDTO` by day id")
    @GetMapping("/dto/day-id/{dayId}")
    public ResponseEntity<DailyDiet> getDailyDietByDayId(@PathVariable Long dayId){
        return new ResponseEntity<>(mealService.getDailyDietByDayId(dayId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `DailyDietDTO` by date and user id")
    @GetMapping("/dto/date/user-id/{date}/{userId}")
    public ResponseEntity<DailyDiet> getDailyDietByDateAndUserId(
            @PathVariable String date, @PathVariable Long userId){
        return new ResponseEntity<>(mealService.getDailyDietByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint addition `Meal`")
    @PostMapping("current/{userId}")
    public ResponseEntity<String> addMeal (@Valid @RequestBody MealDto mealDto, @PathVariable Long userId){
        return new ResponseEntity<>(mealService.addModelByDtoAndUserId(mealDto, userId), HttpStatus.CREATED);
    }

    @ApiOperation(value = "This endpoint input `Meal` object update ")
    @PutMapping("/{userId}")
    public ResponseEntity<String> updateMeal (@Valid @RequestBody MealDto mealDto, @PathVariable Long userId){
        return new ResponseEntity<>(mealService.updateModelByDtoAndUserId(mealDto, userId), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "This endpoint remove `Meal` by id and userId")
    @DeleteMapping("/{id}/{userId}")
    public ResponseEntity<String> deleteMeal (@PathVariable Long id, @PathVariable Long userId){
        return new ResponseEntity<>(mealService.deleteByModelIdAndUserId(id, userId), HttpStatus.ACCEPTED);
    }

}
