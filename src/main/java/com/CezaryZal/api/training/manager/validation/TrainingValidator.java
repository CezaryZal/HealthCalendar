package com.CezaryZal.api.training.manager.validation;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.ApiEntityValidator;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.exceptions.MaximumNumberOfEntitiesPerDayException;
import com.CezaryZal.exceptions.NonOverlappingIdNumberException;
import com.CezaryZal.validation.OverlappingDataValidator;
import com.CezaryZal.validation.PerDayValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrainingValidator implements ApiEntityValidator {

    private final OverlappingDataValidator idsByDateOverlappingDataValidator;
    private final PerDayValidator maxNumberOfTrainingsPerDayValidator;

    public TrainingValidator(OverlappingDataValidator idsByDateOverlappingDataValidator,
                             @Qualifier("trainingsPerDayValidator") PerDayValidator maxNumberOfTrainingsPerDayValidator) {
        this.idsByDateOverlappingDataValidator = idsByDateOverlappingDataValidator;
        this.maxNumberOfTrainingsPerDayValidator = maxNumberOfTrainingsPerDayValidator;
    }

    @Override
    public void validationModelDtoBeforeSaveOrUpdate(ApiEntityDto apiEntityDto, Long userId) {
        TrainingDto trainingDto = (TrainingDto) apiEntityDto;
        throwIfMealsIdDoesNotMatchDate(trainingDto, userId);
        throwIfNumberOfMealsPerDayHasBeenReached(trainingDto, userId);
    }

    private void throwIfMealsIdDoesNotMatchDate(TrainingDto trainingDto, Long userId){
        if (!idsByDateOverlappingDataValidator.isOverlappingIdsByDate(
                trainingDto.getDateTimeOfExecution(),
                trainingDto.getDayId(),
                userId)) {
            throw new NonOverlappingIdNumberException("The dayId from TrainingDto does not match id of Day entity");
        }
    }

    private void throwIfNumberOfMealsPerDayHasBeenReached(TrainingDto trainingDto, Long userId) {
        if (maxNumberOfTrainingsPerDayValidator.hasMaxNumberOfModelsPerDay(
                LocalDate.from(trainingDto.getDateTimeOfExecution()),
                userId)) {
            throw new MaximumNumberOfEntitiesPerDayException("This Day has maximum amount of trainings");
        }
    }

}
