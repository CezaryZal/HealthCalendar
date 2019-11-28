package com.CezaryZal.meal;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService MealS;

    public MealController(MealService MService) {
        this.MealS = MService;
    }

    @GetMapping("/id/{nrId}")
    public MealDB getMealById (@PathVariable Long nrId){
        return MealS.getMealById(nrId);
    }

    @GetMapping("/getDietDTOByDayId/{dayId}")
    public DailyDietDTO getDailyDietByDayId(@PathVariable Long dayId){
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
    public String delete (@PathVariable Long id){
        return MealS.deleteMealById(id);
    }

}
