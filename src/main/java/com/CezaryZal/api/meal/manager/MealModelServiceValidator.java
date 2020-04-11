package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ModelDto;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.exceptions.MaximumNumberOfMealsPerDayException;
import com.CezaryZal.exceptions.NonOverlappingIdNumberException;
import com.CezaryZal.validation.OverlappingDataValidator;
import com.CezaryZal.validation.PerDayValidator;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import com.CezaryZal.validation.validator.ModelServiceValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealModelServiceValidator implements ModelServiceValidator {

    private final OverlappingDataValidator idsByDateOverlappingDataValidator;
    private final PerDayValidator perDayValidator;

    public MealModelServiceValidator(IdsByDateOverlappingDataValidator idsByDateOverlappingDataValidator,
                                     PerDayValidator perDayValidator) {
        this.idsByDateOverlappingDataValidator = idsByDateOverlappingDataValidator;
        this.perDayValidator = perDayValidator;
    }

    @Override
    public void validationModelDtoBeforeSaveOrUpdate(ModelDto modelDto, Long userId) {
        MealDto mealDto = (MealDto) modelDto;
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
        if (perDayValidator.hasMaxNumberOfModelsPerDay(LocalDate.from(mealDto.getDateTimeOfEat()), userId)) {
            throw new MaximumNumberOfMealsPerDayException("This Day has maximum amount of meals");
        }
    }
}