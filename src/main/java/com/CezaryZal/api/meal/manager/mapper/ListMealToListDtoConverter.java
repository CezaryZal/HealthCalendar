package com.CezaryZal.api.meal.manager.mapper;

import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.meal.entity.MealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListMealToListDtoConverter {

    private final MealToDtoConverter mealToDtoConverter;

    @Autowired
    public ListMealToListDtoConverter(MealToDtoConverter mealToDtoConverter) {
        this.mealToDtoConverter = mealToDtoConverter;
    }

    public List<MealDto> mappingList(List<Meal> meals){
        return meals.stream()
                .map(mealToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }
}
