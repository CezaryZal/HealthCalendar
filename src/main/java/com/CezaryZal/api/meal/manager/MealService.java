package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.*;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportUpdater;
import com.CezaryZal.exceptions.not.found.MealNotFoundException;
import com.CezaryZal.api.ApiEntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService implements ApiEntityService {

    private final ApiEntityConverter mealConverter;
    private final DailyDietCreator dailyDietCreator;
    private final ApiEntityCreator mealCreator;
    private final MealRepository mealRepository;
    private final ShortReportUpdater shortReportUpdater;
    private final ApiEntityValidator mealValidator;

    @Autowired
    public MealService(ApiEntityConverter mealConverter,
                       DailyDietCreator dailyDietCreator,
                       ApiEntityCreator mealCreator,
                       MealRepository mealRepository,
                       ShortReportUpdater shortReportUpdater, MealValidator mealValidator) {
        this.mealConverter = mealConverter;
        this.dailyDietCreator = dailyDietCreator;
        this.mealCreator = mealCreator;
        this.mealRepository = mealRepository;
        this.shortReportUpdater = shortReportUpdater;
        this.mealValidator = mealValidator;
    }

    @Override
    public ApiEntityDto getModelDtoByModelId(Long mealId) {
        return mealConverter.mappingApiEntityToDto(mealRepository.findById(mealId)
                .orElseThrow(() -> new MealNotFoundException("Meal not found by id")));
    }

    public DailyDiet getDailyDietByDayId(Long dayId, Long userId) {
        return getDailyDietByListMeal(getMealsByDayId(dayId, userId));
    }

    public DailyDiet getDailyDietByDateAndUserId(String inputDate, Long userId) {
        return getDailyDietByListMeal(mealRepository.findMealListByDateAndUserId(
                                                            LocalDate.parse(inputDate),
                                                            userId).stream()
                                                                    .map(meal -> (ApiEntity)meal)
                                                                    .collect(Collectors.toList()));
    }

    public DailyDiet getDailyDietByListMeal(List<ApiEntity> meals) {
        return dailyDietCreator.createDailyDiet(mealConverter.mappingListApiEntityToListDto(meals));
    }

    public List<MealDto> getMealsDtoByDayIdOrNull(Long dayId) {
        List<ApiEntity> mealListByDayId = mealRepository.findMealListByDayId(dayId).stream()
                                                .map(meal -> (ApiEntity) meal)
                                                .collect(Collectors.toList());

        return mealListByDayId.isEmpty() ?
                null : mealConverter.mappingListApiEntityToListDto(mealListByDayId).stream()
                                                .map(apiEntityDto -> (MealDto) apiEntityDto)
                                                .collect(Collectors.toList());
    }

    private List<ApiEntity> getMealsByDayId(Long dayId, Long userId) {
        return new ArrayList<>(mealRepository.findAllByDayIdAndUserId(dayId, userId)
                .orElseThrow(() -> new MealNotFoundException("Meals not found by day id")));
    }

    public Integer getKcalByDayId(Long dayId) {
        return mealRepository.getKcal(dayId)
                .orElse(0);
    }

    @Override
    public List<ApiEntityDto> getModelsDtoByModelId() {
        return mealConverter.mappingListApiEntityToListDto(new ArrayList<>(mealRepository.findAll()));
    }

    @Override
    public String addModelByDtoAndUserId(ApiEntityDto apiEntityDto, Long userId) {
        MealDto mealDto = (MealDto) apiEntityDto;
        mealValidator.validationModelDtoBeforeSaveOrUpdate(mealDto, userId);
        mealRepository.save((Meal)mealCreator.createApiEntityByDtoAndApiEntityId(apiEntityDto));
        shortReportUpdater.updateShortReportByDayId(mealDto.getDayId());
        return "Received the meal object has been saved to the database";
    }

    @Override
    public String updateModelByDtoAndUserId(ApiEntityDto apiEntityDto, Long userId) {
        MealDto mealDto = (MealDto) apiEntityDto;
        mealValidator.validationModelDtoBeforeSaveOrUpdate(mealDto, userId);
        Meal mealToUpdateByDtoAndUserId = (Meal)mealCreator.createApiEntityToUpdateByDtoAndApiEntityId(apiEntityDto);
        mealRepository.updateMeal(mealToUpdateByDtoAndUserId.getId(),
                mealToUpdateByDtoAndUserId.getDateTimeOfEat(),
                mealToUpdateByDtoAndUserId.getType(),
                mealToUpdateByDtoAndUserId.getKcal(),
                mealToUpdateByDtoAndUserId.getDescription(),
                userId);
        shortReportUpdater.updateShortReportByDayId(mealDto.getDayId());
        return "Received the meal object and the shortReport has been updated";
    }

    @Override
    public String deleteByModelIdAndUserId(Long mealId, Long userId) {
        mealRepository.deleteByIdAndUserID(mealId, userId);
        return "The meal has been removed based on Id";
    }
}
