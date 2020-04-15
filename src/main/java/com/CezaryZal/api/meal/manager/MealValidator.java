package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.exceptions.MaximumNumberOfMealsPerDayException;
import com.CezaryZal.exceptions.NonOverlappingIdNumberException;
import com.CezaryZal.validation.OverlappingDataValidator;
import com.CezaryZal.validation.PerDayValidator;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import com.CezaryZal.api.ApiEntityValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealValidator implements ApiEntityValidator {

    private final OverlappingDataValidator idsByDateOverlappingDataValidator;
    private final PerDayValidator maxNumberOfMealsPerDayValidator;

    public MealValidator(IdsByDateOverlappingDataValidator idsByDateOverlappingDataValidator,
                         PerDayValidator maxNumberOfMealsPerDayValidator) {
        this.idsByDateOverlappingDataValidator = idsByDateOverlappingDataValidator;
        this.maxNumberOfMealsPerDayValidator = maxNumberOfMealsPerDayValidator;
    }

    @Override
    public void validationModelDtoBeforeSaveOrUpdate(ApiEntityDto apiEntityDto, Long userId) {
        MealDto mealDto = (MealDto) apiEntityDto;
        throwIfIdsByDateIsNotOverlapping(mealDto, userId);
        throwIfModelsPerDayHasBeenReached(mealDto, userId);
    }

    private void throwIfIdsByDateIsNotOverlapping(MealDto mealDto, Long userId){
        if (!idsByDateOverlappingDataValidator.isOverlappingIdsByDate(
                mealDto.getDateTimeOfEat(),
                mealDto.getDayId(),
                userId)) {
            throw new NonOverlappingIdNumberException("The dayId from MealDto does not match id of Day entity");
        }
    }

    private void throwIfModelsPerDayHasBeenReached(MealDto mealDto, Long userId) {
        if (maxNumberOfMealsPerDayValidator.hasMaxNumberOfModelsPerDay(LocalDate.from(mealDto.getDateTimeOfEat()), userId)) {
            throw new MaximumNumberOfMealsPerDayException("This Day has maximum amount of meals");
        }
    }
}