package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class MealCreatorTest {

    private MealCreator mealCreator;
    private Meal secondExpectedMeal;

    @BeforeEach
    void setUp() {
        mealCreator = new MealCreator();
        secondExpectedMeal = Meal.builder()
                .dateTimeOfEat(LocalDateTime.of(2020, 5, 15, 15, 15))
                .type("type")
                .kcal(20)
                .description("description")
                .dayId(2L)
                .build();
    }

    @Test
    void shouldReturnProperlyMealFromCreateMealToUpdateByDtoAndMealIdMethod() {
        MealDto firstActualMealDto = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();
        Meal firstExpectedMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();

        Meal firstActualMeal = (Meal)mealCreator.createApiEntityToUpdateByDtoAndApiEntityId(firstActualMealDto);
        assertThat(firstActualMeal).isEqualTo(firstExpectedMeal);
        assertThat(firstExpectedMeal).isNotEqualTo(secondExpectedMeal);
    }

    @Test
    void shouldReturnProperlyMealFromCreateMealByDtoAndMealId() {
        MealDto firstActualMealDto = MealDto.builder()
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();
        Meal firstExpectedMeal = Meal.builder()
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();

        Meal firstActualMeal = (Meal)mealCreator.createApiEntityByDtoAndApiEntityId(firstActualMealDto);
        assertThat(firstActualMeal).isEqualTo(firstExpectedMeal);
        assertThat(firstExpectedMeal).isNotEqualTo(secondExpectedMeal);
    }

    @Test
    void shouldRemoveBlankCharacters() {

        MealDto actualMealDto = MealDto.builder()
                .dateTimeOfEat(LocalDateTime.of(2020, 5, 15, 15, 15))
                .type("   type    ")
                .kcal(20)
                .description("    description      ")
                .dayId(2L)
                .build();

        Meal firstActualMeal = (Meal)mealCreator.createApiEntityByDtoAndApiEntityId(actualMealDto);
        assertThat(firstActualMeal).isEqualTo(secondExpectedMeal);
    }

}