package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.*;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import com.CezaryZal.api.training.model.TrainingsSummary;
import com.CezaryZal.api.training.repo.TrainingRepository;
import com.CezaryZal.exceptions.not.found.TrainingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingService implements ApiEntityService {

    private final TrainingRepository trainingRepository;
    private final ApiEntityConverter trainingConverter;
    private final TrainingsSummaryCreator trainingsSummaryCreator;
    private final ApiEntityCreator trainingCreator;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository,
                           ApiEntityConverter trainingConverter,
                           TrainingsSummaryCreator trainingsSummaryCreator,
                           ApiEntityCreator trainingCreator) {
        this.trainingRepository = trainingRepository;
        this.trainingConverter = trainingConverter;
        this.trainingsSummaryCreator = trainingsSummaryCreator;
        this.trainingCreator = trainingCreator;
    }

    @Override
    public ApiEntityDto getModelDtoByModelId(Long trainingId) {
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new TrainingNotFoundException("Training not found by id"));
        return trainingConverter.mappingApiEntityToDto(training);
    }

    public TrainingsSummary getTrainingsSummaryByTrainings(List<Training> trainingsByDayId){
        List<ApiEntity> apiEntities = new ArrayList<>(trainingsByDayId);
        List<ApiEntityDto> trainingsDto = trainingConverter.mappingListApiEntityToListDto(apiEntities);
        return trainingsSummaryCreator.createTrainingsSummary(trainingsDto);
    }

    public TrainingsSummary getTrainingsSummaryByDayId (Long dayId){
        List<Training> trainingList = getTrainingsByDayId(dayId).stream()
                .map(apiEntity -> (Training)apiEntity)
                .collect(Collectors.toList());
        return getTrainingsSummaryByTrainings(trainingList);
    }

    private List<ApiEntity> getTrainingsByDayId(Long dayId){
        return new ArrayList<>(trainingRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new TrainingNotFoundException("Trainings not found by id")));
    }

    public List<TrainingDto> getTrainingsDtoByDayId(Long dayId){
        List<ApiEntity> trainingListByDayId = new ArrayList<>(trainingRepository.findTrainingListByDayId(dayId));
        List<TrainingDto> trainingDtoList = trainingConverter.mappingListApiEntityToListDto(trainingListByDayId).stream()
                .map(apiEntityDto -> (TrainingDto)apiEntityDto)
                .collect(Collectors.toList());
        return trainingListByDayId.isEmpty() ?
                null : trainingDtoList;
    }

    @Override
    public List<ApiEntityDto> getModelsDtoByModelId() {
        return trainingConverter.mappingListApiEntityToListDto(new ArrayList<>(trainingRepository.findAll()));
    }

    @Override
    public String addModelByDtoAndUserId(ApiEntityDto trainingDto, Long userId) {
        trainingRepository.save((Training) trainingCreator.createApiEntityByDtoAndApiEntityId(trainingDto));
        return "Received the training object has been saved to the database";
    }

    @Override
    public String updateModelByDtoAndUserId(ApiEntityDto trainingDto, Long userId) {
        trainingRepository.save((Training) trainingCreator.createApiEntityToUpdateByDtoAndApiEntityId(trainingDto));
        return "Received the training object and the shortReport has been updated";
    }

    @Override
    public String deleteByModelIdAndUserId(Long mealId, Long userId) {
        trainingRepository.deleteById(mealId);
        return "The training has been removed based on Id";
    }
}
