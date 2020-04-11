package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.springframework.stereotype.Service;

@Service
public class MealCreator {

    Meal createMealToUpdateByDtoAndMealId(MealDto mealDto){
        Meal.Builder builder = mappingDtoToMealBuilder(mealDto);
        return builder
                .id(mealDto.getId())
                .build();
    }

    Meal createMealByDtoAndMealId(MealDto mealDto){
        return mappingDtoToMealBuilder(mealDto).build();
    }

    private Meal.Builder mappingDtoToMealBuilder(MealDto mealDto){
        return Meal.builder()
                .dateTimeOfEat(mealDto.getDateTimeOfEat())
                .type(mealDto.getType().trim())
                .kcal(mealDto.getKcal())
                .description(mealDto.getDescription().trim())
                .dayId(mealDto.getDayId());
    }
}
