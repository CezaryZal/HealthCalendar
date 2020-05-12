package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityCreator;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

@Service
public class TrainingCreator implements ApiEntityCreator {

    @Override
    public ApiEntity createApiEntityToUpdateByDtoAndApiEntityId(ApiEntityDto apiEntityDto) {
        TrainingDto trainingDto = (TrainingDto) apiEntityDto;
        Training.Builder builder = mappingDtoToTraining(trainingDto);
        return builder
                .id(trainingDto.getId())
                .build();
    }

    @Override
    public ApiEntity createApiEntityByDtoAndApiEntityId(ApiEntityDto apiEntityDto) {
        TrainingDto trainingDto = (TrainingDto) apiEntityDto;
        return mappingDtoToTraining(trainingDto).build();
    }

    private Training.Builder mappingDtoToTraining(TrainingDto trainingDto){
        return Training.builder()
                .dateTimeOfExecution(trainingDto.getDateTimeOfExecution())
                .description(trainingDto.getDescription())
                .elapsedTime(trainingDto.getElapsedTime())
                .burnKcal(trainingDto.getBurnKcal())
                .dayId(trainingDto.getDayId());
    }
}
