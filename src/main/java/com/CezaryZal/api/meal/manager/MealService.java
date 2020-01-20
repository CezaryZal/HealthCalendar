package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.meal.entity.MealDto;
import com.CezaryZal.api.meal.manager.creator.DailyDietCreator;
import com.CezaryZal.api.meal.manager.mapper.DtoToMealConverter;
import com.CezaryZal.api.meal.manager.mapper.ListMealToListDtoConverter;
import com.CezaryZal.api.meal.manager.mapper.MealToDtoConverter;
import com.CezaryZal.api.meal.manager.repo.MealRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepoService mealRepoService;
    private final MealToDtoConverter mealToDtoConverter;
    private final DtoToMealConverter dtoToMealConverter;
    private final DailyDietCreator dailyDietCreator;
    private final ListMealToListDtoConverter listMealToListDtoConverter;

    @Autowired
    public MealService(MealRepoService mealRepoService,
                       MealToDtoConverter mealToDtoConverter,
                       DtoToMealConverter dtoToMealConverter,
                       DailyDietCreator dailyDietCreator,
                       ListMealToListDtoConverter listMealToListDtoConverter) {
        this.mealRepoService = mealRepoService;
        this.mealToDtoConverter = mealToDtoConverter;
        this.dtoToMealConverter = dtoToMealConverter;
        this.dailyDietCreator = dailyDietCreator;
        this.listMealToListDtoConverter = listMealToListDtoConverter;
    }

    public MealDto getMealDtoById(Long id) {
        return mealToDtoConverter.mappingEntity(mealRepoService.findMealById(id));
    }

    public DailyDiet getDailyDietByDayId(Long dayId) {
        return getDailyDietByListMeal(mealRepoService.getListMealByDayId(dayId));
    }

    public DailyDiet getDailyDietByListMeal(List<Meal> meals){
        List<MealDto> listMealDto = listMealToListDtoConverter.mappingList(meals);
        return dailyDietCreator.createDailyDiet(listMealDto);
    }

    public List<MealDto> getListMealDto() {
        return listMealToListDtoConverter.mappingList(mealRepoService.getAll());
    }

    public String addMealByDto(MealDto mealDto) {
        mealRepoService.addMeal(dtoToMealConverter.mappingEntity(mealDto));
        return "Przesłany posiłek został zapisany w bazie danych";
    }

    public String updateMealByDto(MealDto mealDto) {
        mealRepoService.updateMeal(dtoToMealConverter.mappingEntity(mealDto));
        return "Przesłane posiłek zostały uaktualnione";
    }

    public String deleteById(Long id) {
        mealRepoService.deleteMealById(id);
        return "Posiłek o przesłanym id został usuniety";
    }

}
