package com.CezaryZal.api.training.manager.mapper;

import com.CezaryZal.api.training.entity.Training;
import com.CezaryZal.api.training.entity.TrainingDto;
import org.springframework.stereotype.Service;

@Service
public class DtoToTrainingConverter {

    public Training mappingEntity(TrainingDto trainingDto){
        return new Training(
                trainingDto.getId(),
                trainingDto.getDateTimeOfExecution(),
                trainingDto.getDescription(),
                trainingDto.getElapsedTime(),
                trainingDto.getBurnKcal(),
                trainingDto.getDayId()
        );
    }
}
