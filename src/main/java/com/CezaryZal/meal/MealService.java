package com.CezaryZal.meal;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private MealRepository MealR;

    public MealService(MealRepository MRepository) {
        this.MealR = MRepository;
    }

    public MealDB getMealById (Long id){
        return MealR.findById(id);
    }

    public DailyDietDTO getDailyDietDTOByDayId (Long dayId){
        List<MealDB> listMealDBS = MealR.getListByDayId(dayId);

        return createDailyDietDTO(listMealDBS);
    }

    public List<MealDB> getAll (){
        return MealR.getAll();
    }

    public boolean addMeal (MealDB mealDB){
        MealR.save(mealDB);

        return true;
    }

    public boolean updateMeal (MealDB mealDB){
        MealR.update(mealDB);

        return true;
    }

    public String deleteMealById (Long id){
        MealDB mealDB = MealR.findById(id);
        if(MealR.delete(mealDB)){
            return "delete record";
        }
        return "Meal id not found";
    }

    public DailyDietDTO createDailyDietDTO (List<MealDB> listMealDBS){
        int sumOfKcal = 0;
        for (MealDB mealDB : listMealDBS){
            sumOfKcal += mealDB.getKcal();
        }
        return new DailyDietDTO(listMealDBS, sumOfKcal);
    }
}
