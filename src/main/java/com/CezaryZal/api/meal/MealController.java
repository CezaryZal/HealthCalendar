package com.CezaryZal.api.meal;

import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.meal.entity.MealDto;
import com.CezaryZal.api.meal.manager.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Meal")
@RestController
@RequestMapping("/api/meal")
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @ApiOperation(value = "This will get a `DailyDietDTO` by day id")
    @GetMapping("/dto/day-id/{dayId}")
    public ResponseEntity<DailyDiet> getDailyDietByDayId(@PathVariable Long dayId){
        return new ResponseEntity<>(mealService.getDailyDietDTOByDayId(dayId), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint addition `Meal`")
    @PostMapping
    public ResponseEntity<String> addMeal (@RequestBody MealDto mealDto){
        return new ResponseEntity<>(mealService.addMealByDto(mealDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "This endpoint input `Meal` object update ")
    @PutMapping
    public ResponseEntity<String> updateMeal (@RequestBody MealDto mealDto){
        return new ResponseEntity<>(mealService.updateMealByDto(mealDto), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint remove `Meal` by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeal (@PathVariable Long id){
        return new ResponseEntity<>(mealService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
