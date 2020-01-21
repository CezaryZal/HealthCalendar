package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.meal.entity.MealDto;
import com.CezaryZal.api.meal.manager.creator.DailyDietCreator;
import com.CezaryZal.api.meal.manager.mapper.MealConverter;
import com.CezaryZal.api.meal.manager.repo.MealRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepoService mealRepoService;
    private final MealConverter mealConverter;
    private final DailyDietCreator dailyDietCreator;

    @Autowired
    public MealService(MealRepoService mealRepoService,
                       MealConverter mealConverter,
                       DailyDietCreator dailyDietCreator) {
        this.mealRepoService = mealRepoService;
        this.mealConverter = mealConverter;
        this.dailyDietCreator = dailyDietCreator;
    }

    public MealDto getMealDtoById(Long id) {
        return mealConverter.mappingMealToDto(mealRepoService.findMealById(id));
    }

    public DailyDiet getDailyDietByDayId(Long dayId) {
        return getDailyDietByListMeal(mealRepoService.getListMealByDayId(dayId));
    }

    public DailyDiet getDailyDietByListMeal(List<Meal> meals){
        List<MealDto> listMealDto = mealConverter.mappingListMealToListDto(meals);
        return dailyDietCreator.createDailyDiet(listMealDto);
    }

    public List<MealDto> getListMealDto() {
        return mealConverter.mappingListMealToListDto(mealRepoService.getAll());
    }

    public String addMealByDto(MealDto mealDto) {
        mealRepoService.addMeal(mealConverter.mappingDtoToMeal(mealDto));
        return "Przesłany posiłek został zapisany w bazie danych";
    }

    public String updateMealByDto(MealDto mealDto) {
        mealRepoService.updateMeal(mealConverter.mappingDtoToMeal(mealDto));
        return "Przesłane posiłek zostały uaktualnione";
    }

    public String deleteById(Long id) {
        mealRepoService.deleteMealById(id);
        return "Posiłek o przesłanym id został usuniety";
    }

}
