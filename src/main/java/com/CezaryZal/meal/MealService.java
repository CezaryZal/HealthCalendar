package com.CezaryZal.meal;

import com.CezaryZal.meal.diet.DailyDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class MealService {

    private MealRepository MRepository;

    @Autowired
    public MealService(MealRepository MRepository) {
        this.MRepository = MRepository;
    }

    public MealDB findById (int id){
        MealDB mealDB = MRepository.findById(id);

        return mealDB;
    }

    public DailyDiet getDailyDiet (String  inputDate, int dayId){
        LocalDate localDate = LocalDate.parse(inputDate);
        List<MealDB> listMealDBS = MRepository.findByDateAndDayId(localDate, dayId);
        int sumOfKcal = 0;
        for (MealDB mealDB : listMealDBS){
            sumOfKcal += mealDB.getKcal();
        }
        DailyDiet dailyDiet = new DailyDiet(listMealDBS, sumOfKcal);

        return dailyDiet;
    }

    public List<MealDB> getAll (){
        List<MealDB> listMealDB = MRepository.getAll();

        return listMealDB;
    }

    public boolean addMeal (MealDB mealDB){
        MRepository.save(mealDB);

        return true;
    }

    public boolean updateMeal (MealDB mealDB){
        MRepository.update(mealDB);

        return true;
    }

    public String deleteMealById (int id){
        MealDB mealDB = MRepository.findById(id);
        if(MRepository.delete(mealDB)){
            return "delete record";
        }
        return "Diet id not found";
    }

}
