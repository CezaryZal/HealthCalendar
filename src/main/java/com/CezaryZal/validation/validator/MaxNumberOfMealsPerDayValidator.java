package com.CezaryZal.validation.validator;

import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.validation.PerDayValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MaxNumberOfMealsPerDayValidator implements PerDayValidator {

    private final byte maxNumberOfMealsPerDay = 4;

    private final MealRepository mealRepository;

    @Autowired
    public MaxNumberOfMealsPerDayValidator(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public boolean hasMaxNumberOfModelsPerDay(LocalDate localDate, Long userId) {
        return mealRepository.getNumberOfMealsContainedOnDay(localDate, userId) > maxNumberOfMealsPerDay;
    }
}
