package com.CezaryZal.api.meal;

import com.CezaryZal.api.meal.entity.DailyDietDTO;
import com.CezaryZal.api.meal.entity.Meal;
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
@Api(tags = "Meal")
@RestController
@RequestMapping("/api/meal")
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @ApiOperation(value = "This will get a `Meal` by id")
    @GetMapping("/{id}")
    public ResponseEntity<MealDto> getMealDtoById (@PathVariable Long id){
        return new ResponseEntity<>(mealService.getMealDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `DailyDietDTO` by day id")
    @GetMapping("/dto/day-id/{dayId}")
    public ResponseEntity<DailyDietDTO> getDailyDietByDayId(@PathVariable Long dayId){
        return new ResponseEntity<>(mealService.getDailyDietDTOByDayId(dayId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Meal`, all records")
    @GetMapping
    public ResponseEntity<List<MealDto>> getListMealDto(){
        return new ResponseEntity<>(mealService.getListMealDto(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMeal (@RequestBody Meal meal){
        return new ResponseEntity<>(mealService.addMealByDto(meal), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateMeal (@RequestBody Meal meal){
        return new ResponseEntity<>(mealService.updateMealByDto(meal), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMeal (@PathVariable Long id){
        return new ResponseEntity<>(mealService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
