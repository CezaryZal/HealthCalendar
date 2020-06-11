package com.CezaryZal.api.meal.manager.validation;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.exceptions.MaximumNumberOfEntitiesPerDayException;
import com.CezaryZal.exceptions.NonOverlappingIdNumberException;
import com.CezaryZal.validation.OverlappingDataValidator;
import com.CezaryZal.validation.PerDayValidator;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import com.CezaryZal.api.ApiEntityValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealValidator implements ApiEntityValidator {

    private final OverlappingDataValidator idsByDateOverlappingDataValidator;
    private final PerDayValidator maxNumberOfMealsPerDayValidator;

    public MealValidator(IdsByDateOverlappingDataValidator idsByDateOverlappingDataValidator,
                         @Qualifier("mealsPerDayValidator") PerDayValidator maxNumberOfMealsPerDayValidator) {
        this.idsByDateOverlappingDataValidator = idsByDateOverlappingDataValidator;
        this.maxNumberOfMealsPerDayValidator = maxNumberOfMealsPerDayValidator;
    }

    @Override
    public void validationModelDtoBeforeSaveOrUpdate(ApiEntityDto apiEntityDto, Long userId) {
        MealDto mealDto = (MealDto) apiEntityDto;
        throwIfMealsIdDoesNotMatchDate(mealDto, userId);
        throwIfNumberOfMealsPerDayHasBeenReached(mealDto, userId);
    }

    private void throwIfMealsIdDoesNotMatchDate(MealDto mealDto, Long userId){
        if (!idsByDateOverlappingDataValidator.isOverlappingIdsByDate(
                mealDto.getDateTimeOfEat(),
                mealDto.getDayId(),
                userId)) {
            throw new NonOverlappingIdNumberException("The dayId from MealDto does not match id of Day entity");
        }
    }

    private void throwIfNumberOfMealsPerDayHasBeenReached(MealDto mealDto, Long userId) {
        if (maxNumberOfMealsPerDayValidator.hasMaxNumberOfModelsPerDay(
                LocalDate.from(mealDto.getDateTimeOfEat()),
                userId)) {
            throw new MaximumNumberOfEntitiesPerDayException("This Day has maximum amount of meals");
        }
    }
}