package com.CezaryZal.api.meal;

import com.CezaryZal.exceptions.not.found.MealNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private MealRepository MealR;

    public MealService(MealRepository MRepository) {
        this.MealR = MRepository;
    }

    public Meal getMealById(Long id) {
        return MealR.findById(id)
                .orElseThrow(() -> new MealNotFoundException("Meal not found by id"));
    }

    public DailyDietDTO getDailyDietDTOByDayId(Long dayId) {
        List<Meal> listMeals = MealR.findAllByDayId(dayId);

        return createDailyDietDTO(listMeals);
    }

    public List<Meal> getAll() {
        return (List<Meal>) MealR.findAll();
    }

    public void addMeal(Meal meal) {
        MealR.save(meal);
    }

    public void updateMeal(Meal meal) {
        MealR.save(meal);
    }

    public void deleteMealById(Long id) {
        MealR.deleteById(id);
    }

    public DailyDietDTO createDailyDietDTO(List<Meal> listMeals) {
        int sumOfKcal = 0;
        for (Meal meal : listMeals) {
            sumOfKcal += meal.getKcal();
        }
        return new DailyDietDTO(listMeals, sumOfKcal);
    }
}
