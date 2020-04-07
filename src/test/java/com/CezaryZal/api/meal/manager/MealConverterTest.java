package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class MealConverterTest {

    MealConverter mealConverter;
    MealDto firstExpectedMealDto;
    MealDto secondExpectedMealDto;
    Meal firstActualMeal;

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
        MealDto actualMealDto = mealConverter.mappingMealToDto(firstActualMeal);
        Assertions.assertThat(actualMealDto).isEqualTo(firstExpectedMealDto);
        Assertions.assertThat(firstExpectedMealDto).isNotEqualTo(secondExpectedMealDto);
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
        List<Meal> actualListMeal = Arrays.asList(firstActualMeal, secondActualMeal);

        List<MealDto> actualListMealDto = mealConverter.mappingListMealToListDto(actualListMeal);

        Assertions.assertThat(actualListMealDto).isEqualTo(expectedListMealDto);
    }
}