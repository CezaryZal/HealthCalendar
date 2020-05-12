package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityConverter;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingConverter implements ApiEntityConverter {

    @Override
    public ApiEntityDto mappingApiEntityToDto(ApiEntity apiEntity) {
        Training training = (Training) apiEntity;
        return TrainingDto.builder()
                .id(training.getId())
                .dateTimeOfExecution(training.getDateTimeOfExecution())
                .description(training.getDescription())
                .elapsedTime(training.getElapsedTime())
                .burnKcal(training.getBurnKcal())
                .dayId(training.getDayId())
                .buildDto();
    }

    @Override
    public List<ApiEntityDto> mappingListApiEntityToListDto(List<ApiEntity> apiEntities) {
        return apiEntities.stream()
                .map(this::mappingApiEntityToDto)
                .collect(Collectors.toList());
    }
}
