package com.CezaryZal.api.meal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class DailyDiet {

    private List<MealDto> listMeals;
    private int sumOfKcal;

}
