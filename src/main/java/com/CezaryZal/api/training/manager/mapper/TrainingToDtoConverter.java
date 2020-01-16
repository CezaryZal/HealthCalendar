package com.CezaryZal.api.training.manager.mapper;

import com.CezaryZal.api.training.entity.Training;
import com.CezaryZal.api.training.entity.TrainingDto;
import org.springframework.stereotype.Service;

@Service
public class TrainingToDtoConverter {

    public TrainingDto mappingEntity(Training training){
        return new TrainingDto(
                training.getId(),
                training.getDateTimeOfExecution(),
                training.getDescription(),
                training.getElapsedTime(),
                training.getBurnKcal(),
                training.getDayId()
        );
    }
}
