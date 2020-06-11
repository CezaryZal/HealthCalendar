package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MealConverterTest {

    private MealConverter mealConverter;
    private MealDto firstExpectedMealDto;
    private MealDto secondExpectedMealDto;
    private Meal firstActualMeal;

    @BeforeEach
    void setUp() {
        mealConverter = new MealConverter();
        firstExpectedMealDto = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();
        secondExpectedMealDto = MealDto.builder()
                .id(2L)
                .dateTimeOfEat(LocalDateTime.of(2020, 12, 12, 12, 12))
                .type("type")
                .kcal(20)
                .description("description")
                .dayId(2L)
                .build();
        firstActualMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();
    }

    @Test
    void shouldReturnProperlyCreatedMealDto(){
        MealDto actualMealDto = (MealDto) mealConverter.mappingApiEntityToDto(firstActualMeal);
        assertThat(actualMealDto).isEqualTo(firstExpectedMealDto);
        assertThat(firstExpectedMealDto).isNotEqualTo(secondExpectedMealDto);
    }

    @Test
    void shouldReturnProperlyCreatedListMealDto() {
        Meal secondActualMeal = Meal.builder()
                .id(2L)
                .dateTimeOfEat(LocalDateTime.of(2020, 12, 12, 12, 12))
                .type("type")
                .kcal(20)
                .description("description")
                .dayId(2L)
                .build();

        List<MealDto> expectedListMealDto = Arrays.asList(firstExpectedMealDto, secondExpectedMealDto);
        List<ApiEntity> actualListMeal = Arrays.asList(firstActualMeal, secondActualMeal);

        List<ApiEntityDto> actualListMealDto = mealConverter.mappingListApiEntityToListDto(actualListMeal);

        assertThat(actualListMealDto).isEqualTo(expectedListMealDto);
    }
}