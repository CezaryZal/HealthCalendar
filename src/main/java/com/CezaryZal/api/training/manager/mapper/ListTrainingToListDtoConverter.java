package com.CezaryZal.api.training.manager.mapper;

import com.CezaryZal.api.training.entity.Training;
import com.CezaryZal.api.training.entity.TrainingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListTrainingToListDtoConverter {

    private final TrainingToDtoConverter trainingToDtoConverter;

    @Autowired
    public ListTrainingToListDtoConverter(TrainingToDtoConverter trainingToDtoConverter) {
        this.trainingToDtoConverter = trainingToDtoConverter;
    }

    public List<TrainingDto> mappingList(List<Training> trainings){
        return trainings.stream()
                .map(trainingToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }
}
