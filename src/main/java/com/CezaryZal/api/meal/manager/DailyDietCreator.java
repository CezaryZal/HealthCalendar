package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.MealDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyDietCreator {

    DailyDiet createDailyDiet(List<MealDto> listMealsDto) {
        int sumOfKcal = listMealsDto.stream()
                .mapToInt(MealDto::getKcal)
                .sum();
        return new DailyDiet(listMealsDto, sumOfKcal);
    }
}
