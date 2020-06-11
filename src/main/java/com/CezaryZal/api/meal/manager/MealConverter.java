package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityConverter;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealConverter implements ApiEntityConverter {

    @Override
    public ApiEntityDto mappingApiEntityToDto(ApiEntity apiEntity) {
        Meal meal = (Meal) apiEntity;
        return MealDto.builder()
                .id(meal.getId())
                .dateTimeOfEat(meal.getDateTimeOfEat())
                .type(meal.getType())
                .kcal(meal.getKcal())
                .description(meal.getDescription())
                .dayId(meal.getDayId())
                .build();
    }

    @Override
    public List<ApiEntityDto> mappingListApiEntityToListDto(List<ApiEntity> meals) {
        return meals.stream()
                .map(this::mappingApiEntityToDto)
                .collect(Collectors.toList());
    }
}
