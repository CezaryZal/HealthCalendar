package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.*;
import com.CezaryZal.api.report.shortened.manager.ShortReportUpdater;
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
    private final ShortReportUpdater shortReportUpdater;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository,
                           ApiEntityConverter trainingConverter,
                           TrainingsSummaryCreator trainingsSummaryCreator,
                           ApiEntityCreator trainingCreator,
                           ShortReportUpdater shortReportUpdater) {
        this.trainingRepository = trainingRepository;
        this.trainingConverter = trainingConverter;
        this.trainingsSummaryCreator = trainingsSummaryCreator;
        this.trainingCreator = trainingCreator;
        this.shortReportUpdater = shortReportUpdater;
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
        List<ApiEntityDto> apiEntityDtos = trainingConverter.mappingListApiEntityToListDto(new ArrayList<>(
                trainingRepository.findTrainingListByDateAndUserId(
                        LocalDate.parse(inputDate),
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
    public String addModelByDtoAndUserId(ApiEntityDto apiEntityDto, Long userId) {
        TrainingDto trainingDto = (TrainingDto) apiEntityDto;
        trainingRepository.save((Training) trainingCreator.createApiEntityByDtoAndApiEntityId(trainingDto));
        shortReportUpdater.updateShortReportByDayId(trainingDto.getDayId());
        return "Received the training object has been saved to the database";
    }

    @Override
    public String updateModelByDtoAndUserId(ApiEntityDto apiEntityDto, Long userId) {
        TrainingDto trainingDto = (TrainingDto) apiEntityDto;
        Training updatedTraining = (Training)trainingCreator.createApiEntityToUpdateByDtoAndApiEntityId(trainingDto);
        trainingRepository.updateTraining(updatedTraining.getId(),
                updatedTraining.getDateTimeOfExecution(),
                updatedTraining.getElapsedTime(),
                updatedTraining.getBurnKcal(),
                updatedTraining.getDescription(),
                userId);
        shortReportUpdater.updateShortReportByDayId(trainingDto.getDayId());
        return "Received the training object and the shortReport has been updated";
    }

    @Override
    public String deleteByModelIdAndUserId(Long trainingId, Long userId) {
        trainingRepository.deleteByIdAndUserID(trainingId, userId);
        return "The training has been removed based on Id";
    }
}
