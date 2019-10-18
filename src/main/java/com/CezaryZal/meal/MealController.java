package com.CezaryZal.meal;


import com.CezaryZal.meal.diet.DailyDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService MService;

    @Autowired
    public MealController(MealService MService) {
        this.MService = MService;
    }

    @GetMapping("/id/{nrId}")
    public MealDB getMealById (@PathVariable int nrId){
        return MService.findById(nrId);
    }

    @GetMapping("/byDateAndDayId/{date}/{dayId}")
    public DailyDiet getListByDateAndDayId(@PathVariable String date, @PathVariable int dayId){
        return MService.getDailyDiet(date, dayId);
    }

    @GetMapping("/getAll")
    public List<MealDB> getAll(){
        return MService.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody MealDB mealDB){
        return MService.addMeal(mealDB);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody MealDB mealDB){
        return MService.updateMeal(mealDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return MService.deleteMealById(id);
    }

}
