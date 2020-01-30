package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingConverter {

    TrainingDto mappingTrainingToDto(Training training){
        return TrainingDto.builder()
                .id(training.getId())
                .dateTimeOfExecution(training.getDateTimeOfExecution())
                .description(training.getDescription())
                .elapsedTime(training.getElapsedTime())
                .burnKcal(training.getBurnKcal())
                .dayId(training.getDayId())
                .buildDto();
    }

    List<TrainingDto> mappingListTrainingToListDto(List<Training> trainings){
        return trainings.stream()
                .map(this::mappingTrainingToDto)
                .collect(Collectors.toList());
    }

}
