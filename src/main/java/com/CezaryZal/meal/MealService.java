package com.CezaryZal.meal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private MealRepository MealR;

    public MealService(MealRepository MRepository) {
        this.MealR = MRepository;
    }

    public Meal getMealById (Long id){
        return MealR.findById(id);
    }

    public DailyDietDTO getDailyDietDTOByDayId (Long dayId){
        List<Meal> listMeals = MealR.getListByDayId(dayId);

        return createDailyDietDTO(listMeals);
    }

    public List<Meal> getAll (){
        return MealR.getAll();
    }

    public boolean addMeal (Meal meal){
        MealR.save(meal);

        return true;
    }

    public boolean updateMeal (Meal meal){
        MealR.update(meal);

        return true;
    }

    public String deleteMealById (Long id){
        Meal meal = MealR.findById(id);
        if(MealR.delete(meal)){
            return "delete record";
        }
        return "Meal id not found";
    }

    public DailyDietDTO createDailyDietDTO (List<Meal> listMeals){
        int sumOfKcal = 0;
        for (Meal meal : listMeals){
            sumOfKcal += meal.getKcal();
        }
        return new DailyDietDTO(listMeals, sumOfKcal);
    }
}
