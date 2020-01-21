package com.CezaryZal.api.meal.model;

import java.time.LocalDateTime;

public class MealDto extends FormMeal {

    public MealDto(
            Long id,
            LocalDateTime dateTimeOfEat,
            String type,
            int kcal,
            String description,
            Long dayId) {
        super(id, dateTimeOfEat, type, kcal, description, dayId);
    }
}
