package com.CezaryZal.api.meal.manager.repo;

import com.CezaryZal.api.meal.MealRepository;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.exceptions.not.found.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MealRepoService {

    private final MealRepository mealRepository;

    @Autowired
    public MealRepoService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    protected Meal findMealById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new MealNotFoundException("Meal not found by id"));
    }

    protected List<Meal> getListMealByDayId(Long dayId){
        return mealRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new MealNotFoundException("Meals not found by day id"));
    }

    protected List<Meal> getAll() {
        return mealRepository.findAll();
    }

    protected void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    protected void updateMeal(Meal meal) {
        mealRepository.save(meal);
    }

    protected void deleteMealById(Long id) {
        mealRepository.deleteById(id);
    }
}
