package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.exceptions.MaximumNumberOfMealsPerDayException;
import com.CezaryZal.exceptions.NonOverlappingIdNumberException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealValidator {

    private final byte maxNumberOfMealsPerDay = 4;

    private final MealRepository mealRepository;
    private final DayRepository dayRepository;

    public MealValidator(MealRepository mealRepository, DayRepository dayRepository) {
        this.mealRepository = mealRepository;
        this.dayRepository = dayRepository;
    }

    void validationBeforeSaveMeal(MealDto mealDto, Long userId){
        throwIfMealsPerDayHasBeenReached(mealDto, userId);
        throwIfDayIdDoesNotMatchWithUserId(mealDto, userId);
    }

    private void throwIfDayIdDoesNotMatchWithUserId(MealDto mealDto, Long userId) {
        if (hasOverlappingDayIdWithIdOfDayEntity(mealDto, userId)){
            throw new NonOverlappingIdNumberException("The dayId from MealDto does not match id of Day entity");
        }
    }

    private void throwIfMealsPerDayHasBeenReached(MealDto mealDto, Long userId){
        if (hasMaxNumberOfMealsPerDay(mealDto, userId)){
            throw new MaximumNumberOfMealsPerDayException("This Day has maximum amount of meals");
        }
    }

    private boolean hasOverlappingDayIdWithIdOfDayEntity(MealDto mealDto, Long userId){
        Long dayIdByDateAndUserId =
                dayRepository.getDayIdByDateAndUserId(LocalDate.from(mealDto.getDateTimeOfEat()), userId)
                        .orElse(0L);
        return !dayIdByDateAndUserId.equals(mealDto.getDayId());
    }

    private boolean hasMaxNumberOfMealsPerDay(MealDto mealDto, Long userId) {
        return mealRepository.getNumberOfMealsContainedOnDay(
                LocalDate.from(mealDto.getDateTimeOfEat()),
                userId) > maxNumberOfMealsPerDay;
    }
}