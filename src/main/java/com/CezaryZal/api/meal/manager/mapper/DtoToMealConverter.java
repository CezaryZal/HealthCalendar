package com.CezaryZal.api.meal.manager.mapper;

import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.meal.entity.MealDto;
import org.springframework.stereotype.Service;

@Service
public class DtoToMealConverter {

    public Meal mappingEntity(MealDto mealDto){
        return new Meal(
                mealDto.getId(),
                mealDto.getDateTimeOfEat(),
                mealDto.getType(),
                mealDto.getKcal(),
                mealDto.getDescription(),
                mealDto.getDayId()
        );
    }
}
