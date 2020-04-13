package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportUpdater;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import com.CezaryZal.validation.validator.MaxNumberOfMealsPerDayValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class MealServiceTest {

    @Mock
    private MealRepository mealRepository;
    @Mock
    private ShortReportUpdater shortReportUpdater;
    @Mock
    private DayRepository dayRepository;

    @Spy
    private MealConverter mealConverter;
    @Spy
    private DailyDietCreator dailyDietCreator;
    @Spy
    private MealCreator mealCreator;

    @InjectMocks
    private MaxNumberOfMealsPerDayValidator maxNumberOfMealsPerDayValidator;
    @InjectMocks
    private IdsByDateOverlappingDataValidator idsByDateOverlappingDataValidator;
    @InjectMocks
    private MealValidator mealValidator;
    @InjectMocks
    private MealService mealService;

    @Test
    public void shouldGetMealDtoByMealId() {
        Meal sampleMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 4, 12, 10, 8))
                .type("sample type")
                .kcal(60)
                .description("sample description")
                .dayId(1L)
                .build();
        MealDto sampleMealDto = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 4, 12, 10, 8))
                .type("sample type")
                .kcal(60)
                .description("sample description")
                .dayId(1L)
                .build();

        when(mealRepository.findById(1L)).thenReturn(java.util.Optional.of(sampleMeal));

        ApiEntityDto modelDtoByModelId = mealService.getModelDtoByModelId(1L);

        Assertions.assertEquals(sampleMealDto, modelDtoByModelId);
    }


}