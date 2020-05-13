package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.*;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import com.CezaryZal.api.training.model.TrainingsSummary;
import com.CezaryZal.api.training.repo.TrainingRepository;
import com.CezaryZal.exceptions.not.found.TrainingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        List<ApiEntityDto> trainingsDto = trainingConverter.mappingListApiEntityToListDto(
                new ArrayList<>(trainingsByDayId));

        return trainingsSummaryCreator.createTrainingsSummary(trainingsDto);
    }

    public TrainingsSummary getTrainingsSummaryByDayId (Long dayId, Long userId){
        return getTrainingsSummaryByTrainings(getTrainingsByDayId(dayId, userId).stream()
                                                    .map(apiEntity -> (Training)apiEntity)
                                                    .collect(Collectors.toList()));
    }

    private List<ApiEntity> getTrainingsByDayId(Long dayId, Long userId){
        return new ArrayList<>(trainingRepository.findTrainingListByDayIdAndUserId(dayId, userId)
                .orElseThrow(() -> new TrainingNotFoundException("Trainings not found by id and user id")));
    }

    public TrainingsSummary getTrainingSummaryByDateAndUserId(String inputDate, Long userId){
        LocalDate inputLocalDate = LocalDate.parse(inputDate);

        List<ApiEntityDto> apiEntityDtos = trainingConverter.mappingListApiEntityToListDto(new ArrayList<>(
                trainingRepository.findTrainingListByDateAndUserId(
                        inputLocalDate.atTime(0,0),
                        inputLocalDate.atTime(23,59),
                        userId)));

        return trainingsSummaryCreator.createTrainingsSummary(apiEntityDtos);
    }

    public List<TrainingDto> getTrainingsDtoByDayId(Long dayId){
        List<ApiEntity> trainingListByDayId = new ArrayList<>(trainingRepository.findTrainingListByDayId(dayId));

        return trainingListByDayId.isEmpty() ?
                null : trainingConverter.mappingListApiEntityToListDto(trainingListByDayId).stream()
                                                .map(apiEntityDto -> (TrainingDto)apiEntityDto)
                                                .collect(Collectors.toList());
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
