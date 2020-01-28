package com.CezaryZal.api.training.manager.mapper;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingConverter {

    public TrainingDto mappingTrainingToDto(Training training){
        return TrainingDto.Builder.builder()
                .id(training.getId())
                .dateTimeOfExecution(training.getDateTimeOfExecution())
                .description(training.getDescription())
                .elapsedTime(training.getElapsedTime())
                .burnKcal(training.getBurnKcal())
                .dayId(training.getDayId())
                .buildDto();
    }

    public List<TrainingDto> mappingListTrainingToListDto(List<Training> trainings){
        return trainings.stream()
                .map(this::mappingTrainingToDto)
                .collect(Collectors.toList());
    }

}
