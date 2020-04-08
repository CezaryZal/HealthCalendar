package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.exceptions.MaximumNumberOfMealsPerDayException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealValidator {

    private final byte maxNumberOfMealsPerDay = 4;

    private MealRepository mealRepository;

    public MealValidator(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    void validationBeforeSaveMeal(MealDto mealDto, Long userId){
        if (hasMaxNumberOfMealsPerDay(mealDto, userId)){
            throw new MaximumNumberOfMealsPerDayException("This day has maximum amount of meals");
        }
    }

    private boolean hasMaxNumberOfMealsPerDay(MealDto mealDto, Long userId) {
        return mealRepository.getNumberOfMealsContainedOnDay(
                LocalDate.from(mealDto.getDateTimeOfEat()),
                userId) > maxNumberOfMealsPerDay;
    }
}
