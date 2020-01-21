package com.CezaryZal.api.training.model;

import com.CezaryZal.api.training.model.FormTraining;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TrainingDto extends FormTraining {

    public TrainingDto(Long id,
                       LocalDateTime dateTimeOfExecution,
                       String description,
                       LocalTime elapsedTime,
                       int burnKcal,
                       Long dayId) {
        super(id, dateTimeOfExecution, description, elapsedTime, burnKcal, dayId);
    }
}
