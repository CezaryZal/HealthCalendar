package com.CezaryZal.api.training.manager.creator;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

@Service
public class TrainingCreator {

    public Training createToUpdateByDtoAndId(TrainingDto trainingDto, Long id){
        Training.Builder builder = mappingDtoToTraining(trainingDto);
        return builder
                .id(id)
                .build();
    }

    public Training createByDtoAndId(TrainingDto trainingDto){
        return mappingDtoToTraining(trainingDto).build();
    }

    private Training.Builder mappingDtoToTraining(TrainingDto trainingDto){
        return Training.Builder.builder()
                .dateTimeOfExecution(trainingDto.getDateTimeOfExecution())
                .description(trainingDto.getDescription())
                .elapsedTime(trainingDto.getElapsedTime())
                .burnKcal(trainingDto.getBurnKcal())
                .dayId(trainingDto.getDayId());
    }
}
