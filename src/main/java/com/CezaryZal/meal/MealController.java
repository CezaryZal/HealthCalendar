package com.CezaryZal.meal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Meal getMealById (@PathVariable int nrId){
        return MService.findById(nrId);
    }

    @GetMapping("/byDateAndDayId/{date}/{dayId}")
    public List<Meal> getListByDateAndDayId(@PathVariable String date, @PathVariable int dayId){
        return MService.getListByDateAndDayId(date, dayId);
    }

    @GetMapping("/getAll")
    public List<Meal> getAll(){
        return MService.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody Meal meal){
        return MService.addMeal(meal);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody Meal meal){
        return MService.updateMeal(meal);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return MService.deleteMealById(id);
    }

}
