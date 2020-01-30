package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.springframework.stereotype.Service;

@Service
public class MealCreator {

    Meal createToUpdateByDtoAndMealId(MealDto mealDto, Long mealId){
        Meal.Builder builder = mappingDtoToMealBuilder(mealDto);
        return builder
                .id(mealId)
                .build();
    }

    Meal createByDtoAndMealId(MealDto mealDto){
        return mappingDtoToMealBuilder(mealDto).build();
    }

    private Meal.Builder mappingDtoToMealBuilder(MealDto mealDto){
        return Meal.builder()
                .dateTimeOfEat(mealDto.getDateTimeOfEat())
                .type(mealDto.getType())
                .kcal(mealDto.getKcal())
                .description(mealDto.getDescription())
                .dayId(mealDto.getDayId());
    }
}
