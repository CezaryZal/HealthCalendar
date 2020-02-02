package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.api.structure.models.FormEntityDto;
import com.CezaryZal.exceptions.not.found.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {

    private final DailyDietCreator dailyDietCreator;
    private final MealRepository mealRepository;
    private final MealManager mealManager;

    @Autowired
    public MealService(DailyDietCreator dailyDietCreator,
                       MealRepository mealRepository,
                       MealManager mealManager) {
        this.dailyDietCreator = dailyDietCreator;
        this.mealRepository = mealRepository;
        this.mealManager = mealManager;
    }

    public MealDto getMealDtoById(Long id) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new MealNotFoundException("Meal not found by id"));
        return mealManager.convertDtoByEntity(meal);
    }

    public DailyDiet getDailyDietByDayId(Long dayId) {
        List<Meal> meals = mealRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new MealNotFoundException("Meals not found by day id"));
        return getDailyDietByListMeal(meals);
    }

    public DailyDiet getDailyDietByListMeal(List<Meal> meals){
        List<MealDto> mealsDto = meals.stream()
                .map(mealManager::convertDtoByEntity)
                .map(tmp -> (MealDto) tmp)
                .collect(Collectors.toList());
        return dailyDietCreator.createDailyDiet(mealsDto);
    }

    public List<MealDto> getListMealDto() {
        List<Meal> allMeals = mealRepository.findAll();
        return allMeals.stream()
                .map(mealManager::convertDtoByEntity)
                .collect(Collectors.toList());
    }

    public String addMealByDto(FormEntityDto formEntityDto) {
        Meal newMeal = (Meal) mealManager.createNewEntityByEntityDto(formEntityDto);
        mealRepository.save(newMeal);
        return "Przesłany posiłek został zapisany w bazie danych";
    }

    public String updateMealByDto(FormEntityDto formEntityDto, Long mealId) {
        Meal meal = (Meal) mealManager.createEntityToUpdateByEntityDto(formEntityDto, mealId);
        mealRepository.save(meal);
        return "Przesłane posiłek zostały uaktualnione";
    }

    public String deleteById(Long id) {
        mealRepository.deleteById(id);
        return "Posiłek o przesłanym id został usuniety";
    }

    public Integer getKcalByDayId(Long dayId) {
        return mealRepository.getKcal(dayId)
                .orElse(0);
    }

}
