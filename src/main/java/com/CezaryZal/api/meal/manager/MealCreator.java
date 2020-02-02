package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.structure.ApiCreator;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public class MealCreator implements ApiCreator {

    @Override
    public FormEntity createNewEntity(FormEntityDto formEntityDto) {
        return mappingDtoToMealBuilder(formEntityDto).build();
    }

    @Override
    public FormEntity createEntityToUpdate(FormEntityDto formEntityDto, Long mealId) {
        Meal.Builder builder = mappingDtoToMealBuilder(formEntityDto);
        return builder
                .id(mealId)
                .build();
    }

    private Meal.Builder mappingDtoToMealBuilder(FormEntityDto formEntityDto){
        MealDto mealDto = (MealDto) formEntityDto;
        return Meal.builder()
                .dateTimeOfEat(mealDto.getDateTimeOfEat())
                .type(mealDto.getType())
                .kcal(mealDto.getKcal())
                .description(mealDto.getDescription())
                .dayId(mealDto.getDayId());
    }
}
