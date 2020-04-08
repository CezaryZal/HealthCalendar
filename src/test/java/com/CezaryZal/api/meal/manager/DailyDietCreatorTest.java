package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.MealDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class DailyDietCreatorTest {

    @Test
    void shouldReturnDailyDietFromCreateDailyDietMethod() {
        DailyDietCreator dailyDietCreator = new DailyDietCreator();

        MealDto firstExpectedMealDto = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 11, 11, 11, 11))
                .type("type")
                .kcal(10)
                .description("description")
                .dayId(1L)
                .build();
        MealDto secondExpectedMealDto = MealDto.builder()
                .id(2L)
                .dateTimeOfEat(LocalDateTime.of(2020, 12, 12, 12, 12))
                .type("type")
                .kcal(20)
                .description("description")
                .dayId(2L)
                .build();

        List<MealDto> listMealDto = Arrays.asList(firstExpectedMealDto, secondExpectedMealDto);

        DailyDiet actualDailyDiet = dailyDietCreator.createDailyDiet(listMealDto);
        DailyDiet expectedDailyDiet = new DailyDiet(listMealDto, 30);
        DailyDiet notExpectedDailyDiet = new DailyDiet(listMealDto, 50);

        Assertions.assertThat(actualDailyDiet).isEqualTo(expectedDailyDiet);
        Assertions.assertThat(actualDailyDiet).isNotEqualTo(notExpectedDailyDiet);
    }

}