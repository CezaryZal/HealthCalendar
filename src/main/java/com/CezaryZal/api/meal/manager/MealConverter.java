package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealConverter {

    MealDto mappingMealToDto(Meal meal){
        return MealDto.builder()
                .id(meal.getId())
                .dateTimeOfEat(meal.getDateTimeOfEat())
                .type(meal.getType())
                .kcal(meal.getKcal())
                .description(meal.getDescription())
                .dayId(meal.getDayId())
                .build();
    }

    List<MealDto> mappingListMealToListDto(List<Meal> meals){
        return meals.stream()
                .map(this::mappingMealToDto)
                .collect(Collectors.toList());
    }
}
