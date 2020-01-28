package com.CezaryZal.api.meal.manager.creator;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.springframework.stereotype.Service;

@Service
public class MealCreator {

    public Meal createToUpdateByDtoAndMealId(MealDto mealDto, Long mealId){
        Meal.Builder builder = mappingDtoToMealBuilder(mealDto);
        return builder
                .id(mealId)
                .build();
    }

    public Meal createByDtoAndMealId(MealDto mealDto){
        return mappingDtoToMealBuilder(mealDto).build();
    }

    private Meal.Builder mappingDtoToMealBuilder(MealDto mealDto){
        return Meal.Builder.builder()
                .dateTimeOfEat(mealDto.getDateTimeOfEat())
                .type(mealDto.getType())
                .kcal(mealDto.getKcal())
                .description(mealDto.getDescription())
                .dayId(mealDto.getDayId());
    }
}
