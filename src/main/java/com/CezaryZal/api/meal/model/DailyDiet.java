package com.CezaryZal.api.meal.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class DailyDiet {

    private List<MealDto> listMeals;
    private int sumOfKcal;

}
