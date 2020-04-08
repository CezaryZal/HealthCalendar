package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportUpdater;
import com.CezaryZal.exceptions.not.found.MealNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MealService {

    private final MealConverter mealConverter;
    private final DailyDietCreator dailyDietCreator;
    private final MealCreator mealCreator;
    private final MealRepository mealRepository;
    private final ShortReportUpdater shortReportUpdater;

    @Autowired
    public MealService(MealConverter mealConverter,
                       DailyDietCreator dailyDietCreator,
                       MealCreator mealCreator,
                       MealRepository mealRepository,
                       ShortReportUpdater shortReportUpdater) {
        this.mealConverter = mealConverter;
        this.dailyDietCreator = dailyDietCreator;
        this.mealCreator = mealCreator;
        this.mealRepository = mealRepository;
        this.shortReportUpdater = shortReportUpdater;
    }

    public MealDto getMealDtoById(Long mealId) {
        Meal meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new MealNotFoundException("Meal not found by id"));
        return mealConverter.mappingMealToDto(meal);
    }

    public DailyDiet getDailyDietByDayId(Long dayId) {
        return getDailyDietByListMeal(getMealsByDayId(dayId));
    }

    public DailyDiet getDailyDietByDateAndUserId(String inputDate, Long userId){
        List<Meal> mealListByDateAndUserId =
                mealRepository.findMealListByDateAndUserId(LocalDate.parse(inputDate), userId);
        return getDailyDietByListMeal(mealListByDateAndUserId);
    }

    public DailyDiet getDailyDietByListMeal(List<Meal> meals){
        List<MealDto> listMealDto = mealConverter.mappingListMealToListDto(meals);
        return dailyDietCreator.createDailyDiet(listMealDto);
    }

    public List<MealDto> getMealsDtoByDayIdOrNull(Long dayId){
        List<Meal> mealListByDayId = mealRepository.findMealListByDayId(dayId);
        return mealListByDayId.isEmpty() ? null : mealConverter.mappingListMealToListDto(mealListByDayId);
    }

    private List<Meal> getMealsByDayId(Long dayId){
        return mealRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new MealNotFoundException("Meals not found by day id"));
    }

    public Integer getKcalByDayId(Long dayId) {
        return mealRepository.getKcal(dayId)
                .orElse(0);
    }

    public int getNumberOfMealsContainedOnDayByDateAndUserId(String inputDate, Long userId){
        return mealRepository.getNumberOfMealsContainedOnDay(LocalDate.parse(inputDate), userId);
    }

    public List<MealDto> getListMealDto() {
        return mealConverter.mappingListMealToListDto(mealRepository.findAll());
    }

    public String addMealByDto(MealDto mealDto) {
        mealRepository.save(mealCreator.createMealByDtoAndMealId(mealDto));
        shortReportUpdater.updateShortReportByDayId(mealDto.getDayId());
        return "Received the meal object has been saved to the database";
    }

    public String updateMealByDto(MealDto mealDto, Long mealId) {
        mealRepository.save(mealCreator.createMealToUpdateByDtoAndMealId(mealDto, mealId));
        shortReportUpdater.updateShortReportByDayId(mealDto.getDayId());
        return "Received the meal object and the shortReport has been updated";
    }

    public String deleteByIdAndUserId(Long id, Long userId) {
        mealRepository.deleteByIdAndUserID(id, userId);
        return "The meal has been removed based on Id";
    }
}
