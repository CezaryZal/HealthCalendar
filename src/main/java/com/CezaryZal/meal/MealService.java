package com.CezaryZal.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
@Service
public class MealService {

    private MealRepository MealR;

    @Autowired
    public MealService(MealRepository MRepository) {
        this.MealR = MRepository;
    }

    public MealDB getMealById (int id){
        return MealR.findById(id);
    }

    public DailyDietDTO getDailyDietDTOByDayId (int dayId){
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

    public String deleteMealById (int id){
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
