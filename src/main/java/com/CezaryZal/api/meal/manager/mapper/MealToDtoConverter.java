package com.CezaryZal.api.meal.manager.mapper;

import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.meal.entity.MealDto;
import org.springframework.stereotype.Service;

@Service
public class MealToDtoConverter {

    public MealDto mappingEntity(Meal meal){
        return new MealDto(
                meal.getId(),
                meal.getDateTimeOfEat(),
                meal.getType(),
                meal.getKcal(),
                meal.getDescription(),
                meal.getDayId()
        );
    }
}
