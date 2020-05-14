package com.CezaryZal.api.training.manager.validation;

import com.CezaryZal.api.training.repo.TrainingRepository;
import com.CezaryZal.validation.PerDayValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("trainingsPerDayValidator")
public class MaxNumberOfTrainingsPerDayValidator implements PerDayValidator {

    private final byte maxNumberOfMealsPerDay = 4;

    private final TrainingRepository trainingRepository;

    @Autowired
    public MaxNumberOfTrainingsPerDayValidator(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public boolean hasMaxNumberOfModelsPerDay(LocalDate localDate, Long userId) {
        return trainingRepository.getNumberOfTrainingsContainedOnDay(localDate, userId) > maxNumberOfMealsPerDay;
    }
}
