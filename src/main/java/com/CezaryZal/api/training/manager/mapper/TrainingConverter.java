package com.CezaryZal.api.training.manager.mapper;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingConverter {

    public TrainingDto mappingTrainingToDto(Training training){
        return new TrainingDto(
                training.getId(),
                training.getDateTimeOfExecution(),
                training.getDescription(),
                training.getElapsedTime(),
                training.getBurnKcal(),
                training.getDayId()
        );
    }

    public Training mappingDtoToTraining(TrainingDto trainingDto){
        return new Training(
                trainingDto.getId(),
                trainingDto.getDateTimeOfExecution(),
                trainingDto.getDescription(),
                trainingDto.getElapsedTime(),
                trainingDto.getBurnKcal(),
                trainingDto.getDayId()
        );
    }

    public List<TrainingDto> mappingListTrainingToListDto(List<Training> trainings){
        return trainings.stream()
                .map(this::mappingTrainingToDto)
                .collect(Collectors.toList());
    }

}
