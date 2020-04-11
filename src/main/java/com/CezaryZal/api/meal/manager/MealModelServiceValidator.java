package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.ModelDto;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.exceptions.NonOverlappingIdNumberException;
import com.CezaryZal.validation.OverlappingDataValidator;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import com.CezaryZal.validation.validator.ModelServiceValidator;
import org.springframework.stereotype.Service;

@Service
public class MealModelServiceValidator implements ModelServiceValidator {

    private OverlappingDataValidator idsByDateOverlappingDataValidator;

    public MealModelServiceValidator(IdsByDateOverlappingDataValidator idsByDateOverlappingDataValidator) {
        this.idsByDateOverlappingDataValidator = idsByDateOverlappingDataValidator;
    }

    @Override
    public void validationModelDtoBeforeSaveOrUpdate(ModelDto modelDto, Long userId) {
        MealDto mealDto = (MealDto) modelDto;
        if (!idsByDateOverlappingDataValidator.isOverlappingIdsByDate(
                mealDto.getDateTimeOfEat(),
                mealDto.getDayId(),
                userId)){
            throw new NonOverlappingIdNumberException("The dayId from MealDto does not match id of Day entity");
        }
    }

}