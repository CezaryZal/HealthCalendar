package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.structure.ApiConverter;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public class MealConverter implements ApiConverter {

    @Override
    public MealDto convertDtoByEntity(FormEntity formEntity) {
        Meal meal = (Meal) formEntity;
        return MealDto.builder()
                .id(meal.getId())
                .dateTimeOfEat(meal.getDateTimeOfEat())
                .type(meal.getType())
                .kcal(meal.getKcal())
                .description(meal.getDescription())
                .dayId(meal.getDayId())
                .build();
    }

}
