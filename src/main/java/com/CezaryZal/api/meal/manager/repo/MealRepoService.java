package com.CezaryZal.api.meal.manager.repo;

import com.CezaryZal.api.meal.MealRepository;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.exceptions.not.found.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealRepoService {

    private final MealRepository mealRepository;

    @Autowired
    public MealRepoService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal findMealById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new MealNotFoundException("Meal not found by id"));
    }

    public List<Meal> getListMealByDayId(Long dayId) {
        return mealRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new MealNotFoundException("Meals not found by day id"));
    }

    public Integer getKcalByDayId(Long dayId) {
        return mealRepository.getKcal(dayId)
                .orElseGet(() -> 0);
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void deleteMealById(Long id) {
        mealRepository.deleteById(id);
    }
}
