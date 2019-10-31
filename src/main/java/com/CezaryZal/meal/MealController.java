package com.CezaryZal.meal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService MealS;

    @Autowired
    public MealController(MealService MService) {
        this.MealS = MService;
    }

    @GetMapping("/id/{nrId}")
    public MealDB getMealById (@PathVariable int nrId){
        return MealS.getMealById(nrId);
    }

    @GetMapping("/getDietDTOByDayId/{dayId}")
    public DailyDietDTO getDailyDietByDayId(@PathVariable int dayId){
        return MealS.getDailyDietDTOByDayId(dayId);
    }

    @GetMapping("/getAll")
    public List<MealDB> getAll(){
        return MealS.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody MealDB mealDB){
        return MealS.addMeal(mealDB);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody MealDB mealDB){
        return MealS.updateMeal(mealDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return MealS.deleteMealById(id);
    }

}
