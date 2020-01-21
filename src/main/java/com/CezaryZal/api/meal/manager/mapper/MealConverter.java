package com.CezaryZal.api.meal.manager.mapper;

import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealConverter {

    public MealDto mappingMealToDto(Meal meal){
        return new MealDto(
                meal.getId(),
                meal.getDateTimeOfEat(),
                meal.getType(),
                meal.getKcal(),
                meal.getDescription(),
                meal.getDayId()
        );
    }

    public Meal mappingDtoToMeal(MealDto mealDto){
        return new Meal(
                mealDto.getId(),
                mealDto.getDateTimeOfEat(),
                mealDto.getType(),
                mealDto.getKcal(),
                mealDto.getDescription(),
                mealDto.getDayId()
        );
    }

    public List<MealDto> mappingListMealToListDto(List<Meal> meals){
        return meals.stream()
                .map(this::mappingMealToDto)
                .collect(Collectors.toList());
    }
}
