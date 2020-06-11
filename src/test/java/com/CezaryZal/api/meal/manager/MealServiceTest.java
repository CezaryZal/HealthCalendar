package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.meal.manager.validation.MealValidator;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportUpdater;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import com.CezaryZal.api.meal.manager.validation.MaxNumberOfMealsPerDayValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
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

    private Meal firstSampleMeal;
    private MealDto firstSampleMealDto;
    private Meal secondSampleMeal;
    private MealDto secondSampleMealDto;

    private List<Meal> firstMealList;
    private List<MealDto> firstMealDtoList;

    @BeforeEach
    void setUp() {
        firstSampleMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 4, 12, 10, 8))
                .type("first type")
                .kcal(60)
                .description("first description")
                .dayId(1L)
                .build();

        firstSampleMealDto = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2020, 4, 12, 10, 8))
                .type("first type")
                .kcal(60)
                .description("first description")
                .dayId(1L)
                .build();

        secondSampleMeal = Meal.builder()
                .id(2L)
                .dateTimeOfEat(LocalDateTime.of(2020, 4, 13, 11, 9))
                .type("second type")
                .kcal(70)
                .description("second description")
                .dayId(2L)
                .build();

        secondSampleMealDto = MealDto.builder()
                .id(2L)
                .dateTimeOfEat(LocalDateTime.of(2020, 4, 13, 11, 9))
                .type("second type")
                .kcal(70)
                .description("second description")
                .dayId(2L)
                .build();

        firstMealList = Arrays.asList(firstSampleMeal, secondSampleMeal);
        firstMealDtoList = Arrays.asList(firstSampleMealDto, secondSampleMealDto);
    }

    @Test
    public void shouldGetMealDtoByMealId() {
        when(mealRepository.findById(1L)).thenReturn(Optional.of(firstSampleMeal));

        ApiEntityDto actualModelDtoByModelId = mealService.getModelDtoByModelId(1L);

        assertEquals(firstSampleMealDto, actualModelDtoByModelId);
        assertNotEquals(secondSampleMealDto, actualModelDtoByModelId);
    }

    @Test
    public void shouldGetMealsDtoByDayId() {
        when(mealRepository.findMealListByDayId(1L)).thenReturn(firstMealList);

        List<MealDto> actualMealDtoList = mealService.getMealsDtoByDayIdOrNull(1L);

        assertEquals(firstMealDtoList, actualMealDtoList);
    }

    @Test
    public void shouldGetDailyDietByListMeal() {
        DailyDiet expectedDailyDiet = new DailyDiet(
                        firstMealDtoList.stream().map(mealDto ->(ApiEntityDto)mealDto).collect(Collectors.toList()),
                130);
        List<ApiEntity> actualListApiEntity = firstMealList.stream()
                .map(meal -> (ApiEntity) meal)
                .collect(Collectors.toList());

        DailyDiet actualDailyDiet = mealService.getDailyDietByListMeal(actualListApiEntity);

        assertEquals(expectedDailyDiet, actualDailyDiet);
    }

    @Test
    public void shouldGetDailyDietByDateAndUserId() {
        DailyDiet expectedDailyDiet = new DailyDiet(
                firstMealDtoList.stream().map(mealDto ->(ApiEntityDto)mealDto).collect(Collectors.toList()),
                130);
        when(mealRepository.findMealListByDateAndUserId(LocalDate.of(2020,4,8), 1L))
                .thenReturn(firstMealList);

        DailyDiet actualDailyDiet = mealService.getDailyDietByDateAndUserId("2020-04-08", 1L);

        assertEquals(expectedDailyDiet, actualDailyDiet);
    }
}