package com.CezaryZal.api.meal.model;

import com.CezaryZal.api.ApiEntityDto;
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

    private final List<ApiEntityDto> listMeals;
    private final int sumOfKcal;

}
