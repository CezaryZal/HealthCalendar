package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.entity.Meal;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class MealCreatorTest {


    @Test
    void shouldCompareTwoSimilarMeals(){
        Meal expectedMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2018, 12, 20, 12, 6, 23))
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        Meal newMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2018, 12, 20, 12, 6, 23))
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        assertThat(expectedMeal).isEqualTo(newMeal);
    }
}