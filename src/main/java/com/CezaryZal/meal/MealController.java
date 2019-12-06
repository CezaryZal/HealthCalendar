package com.CezaryZal.meal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Meal")
@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService MealS;

    public MealController(MealService MService) {
        this.MealS = MService;
    }

    @ApiOperation(value = "This will get a `Meal` by id")
    @GetMapping("/{id}")
    public Meal getMealById (@PathVariable Long id){
        return MealS.getMealById(id);
    }

    @ApiOperation(value = "This will get a `DailyDietDTO` by day id")
    @GetMapping("/dto/day-id/{dayId}")
    public DailyDietDTO getDailyDietByDayId(@PathVariable Long dayId){
        return MealS.getDailyDietDTOByDayId(dayId);
    }

    @ApiOperation(value = "This will get a list `Meal`, all records")
    @GetMapping
    public List<Meal> getAll(){
        return MealS.getAll();
    }

    @PostMapping
    public boolean addDiet (@RequestBody Meal meal){
        return MealS.addMeal(meal);
    }

    @PutMapping
    public boolean updateMeal (@RequestBody Meal meal){
        return MealS.updateMeal(meal);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return MealS.deleteMealById(id);
    }

}
