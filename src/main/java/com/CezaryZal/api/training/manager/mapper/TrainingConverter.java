package com.CezaryZal.api.training.manager.mapper;

import com.CezaryZal.api.training.model.FormTraining;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingConverter {

    public FormTraining mappingTrainingToDto(Training training){
        return TrainingDto.Builder.builder()
                .id(training.getId())
                .dateTimeOfExecution(training.getDateTimeOfExecution())
                .description(training.getDescription())
                .elapsedTime(training.getElapsedTime())
                .burnKcal(training.getBurnKcal())
                .dayId(training.getDayId())
                .build();
    }

    public Training mappingDtoToTraining(TrainingDto trainingDto){
        return Training.Builder.builder()
                .id(trainingDto.getId())
                .dateTimeOfExecution(trainingDto.getDateTimeOfExecution())
                .description(trainingDto.getDescription())
                .elapsedTime(trainingDto.getElapsedTime())
                .burnKcal(trainingDto.getBurnKcal())
                .dayId(trainingDto.getDayId())
                .build();
    }

    public List<FormTraining> mappingListTrainingToListDto(List<Training> trainings){
        return trainings.stream()
                .map(this::mappingTrainingToDto)
                .collect(Collectors.toList());
    }

}
