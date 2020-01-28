package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.manager.creator.MealCreator;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
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
    private final MealCreator mealCreator;

    @Autowired
    public MealService(MealRepoService mealRepoService,
                       MealConverter mealConverter,
                       DailyDietCreator dailyDietCreator,
                       MealCreator mealCreator) {
        this.mealRepoService = mealRepoService;
        this.mealConverter = mealConverter;
        this.dailyDietCreator = dailyDietCreator;
        this.mealCreator = mealCreator;
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
        mealRepoService.addMeal(mealCreator.createByDtoAndMealId(mealDto));
        return "Przesłany posiłek został zapisany w bazie danych";
    }

    public String updateMealByDto(MealDto mealDto, Long mealId) {
        mealRepoService.updateMeal(mealCreator.createToUpdateByDtoAndMealId(mealDto, mealId));
        return "Przesłane posiłek zostały uaktualnione";
    }

    public String deleteById(Long id) {
        mealRepoService.deleteMealById(id);
        return "Posiłek o przesłanym id został usuniety";
    }

}
