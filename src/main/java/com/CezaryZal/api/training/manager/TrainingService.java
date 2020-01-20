package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.training.entity.Training;
import com.CezaryZal.api.training.entity.TrainingDto;
import com.CezaryZal.api.training.entity.TrainingsSummary;
import com.CezaryZal.api.training.manager.creator.TrainingsSummaryCreator;
import com.CezaryZal.api.training.manager.mapper.DtoToTrainingConverter;
import com.CezaryZal.api.training.manager.mapper.ListTrainingToListDtoConverter;
import com.CezaryZal.api.training.manager.mapper.TrainingToDtoConverter;
import com.CezaryZal.api.training.manager.repo.TrainingRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepoService trainingRepoService;
    private final TrainingToDtoConverter trainingToDtoConverter;
    private final DtoToTrainingConverter dtoToTrainingConverter;
    private final TrainingsSummaryCreator trainingsSummaryCreator;
    private final ListTrainingToListDtoConverter listTrainingToListDtoConverter;

    @Autowired
    public TrainingService(TrainingRepoService trainingRepoService,
                           TrainingToDtoConverter trainingToDtoConverter,
                           DtoToTrainingConverter dtoToTrainingConverter,
                           TrainingsSummaryCreator trainingsSummaryCreator,
                           ListTrainingToListDtoConverter listTrainingToListDtoConverter) {
        this.trainingRepoService = trainingRepoService;
        this.trainingToDtoConverter = trainingToDtoConverter;
        this.dtoToTrainingConverter = dtoToTrainingConverter;
        this.trainingsSummaryCreator = trainingsSummaryCreator;
        this.listTrainingToListDtoConverter = listTrainingToListDtoConverter;
    }

    public TrainingDto getTrainingDtoById (Long id){
        return trainingToDtoConverter.mappingEntity(trainingRepoService.getTrainingById(id));
    }

    public TrainingsSummary getTrainingsSummaryByDayId (Long dayId){
        return getTrainingsSummaryByTrainings(trainingRepoService.getTrainingsByDayId(dayId));
    }

    public TrainingsSummary getTrainingsSummaryByTrainings(List<Training> trainingsByDayId){
        List<TrainingDto> trainingsDto = listTrainingToListDtoConverter.mappingList(trainingsByDayId);
        return trainingsSummaryCreator.createTrainingsSummary(trainingsDto);
    }

    public List<TrainingDto> getAllTrainingsDto (){
        return listTrainingToListDtoConverter.mappingList(trainingRepoService.getAllTrainings());
    }

    public String addTrainingByDto (TrainingDto trainingDto){
        trainingRepoService.addTraining(dtoToTrainingConverter.mappingEntity(trainingDto));
        return "Przesłany trening został zapisany w bazie danych";
    }

    public String updateTrainingByDto (TrainingDto trainingDto){
        trainingRepoService.updateTraining(dtoToTrainingConverter.mappingEntity(trainingDto));
        return "Przesłany trening został uaktualniony";
    }

    public String deleteTraining (Long id){
        trainingRepoService.deleteTrainingById(id);
        return "Trening o przesłanym id została usuniety";
    }
}
