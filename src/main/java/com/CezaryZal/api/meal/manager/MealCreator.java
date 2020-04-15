package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityCreator;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.springframework.stereotype.Service;

@Service
public class MealCreator implements ApiEntityCreator {

    @Override
    public ApiEntity createApiEntityToUpdateByDtoAndApiEntityId(ApiEntityDto apiEntityDto) {
        MealDto mealDto = (MealDto)apiEntityDto;
        Meal.Builder builder = mappingDtoToMealBuilder(mealDto);
        return builder
                .id(mealDto.getId())
                .build();
    }

    @Override
    public ApiEntity createApiEntityByDtoAndApiEntityId(ApiEntityDto apiEntityDto) {
        MealDto mealDto = (MealDto)apiEntityDto;
        return mappingDtoToMealBuilder(mealDto).build();
    }

    private Meal.Builder mappingDtoToMealBuilder(MealDto mealDto){
        return Meal.builder()
                .dateTimeOfEat(mealDto.getDateTimeOfEat())
                .type(mealDto.getType().trim())
                .kcal(mealDto.getKcal())
                .description(mealDto.getDescription().trim())
                .dayId(mealDto.getDayId());
    }
}
