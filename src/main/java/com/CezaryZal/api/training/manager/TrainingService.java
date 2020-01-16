package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.training.TrainingRepository;
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
public class TrainingService extends TrainingRepoService {

    private final TrainingToDtoConverter trainingToDtoConverter;
    private final DtoToTrainingConverter dtoToTrainingConverter;
    private final TrainingsSummaryCreator trainingsSummaryCreator;
    private final ListTrainingToListDtoConverter listTrainingToListDtoConverter;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository,
                           TrainingToDtoConverter trainingToDtoConverter,
                           DtoToTrainingConverter dtoToTrainingConverter,
                           TrainingsSummaryCreator trainingsSummaryCreator,
                           ListTrainingToListDtoConverter listTrainingToListDtoConverter) {
        super(trainingRepository);
        this.trainingToDtoConverter = trainingToDtoConverter;
        this.dtoToTrainingConverter = dtoToTrainingConverter;
        this.trainingsSummaryCreator = trainingsSummaryCreator;
        this.listTrainingToListDtoConverter = listTrainingToListDtoConverter;
    }

    public TrainingDto getTrainingDtoById (Long id){
        return trainingToDtoConverter.mappingEntity(getTrainingById(id));
    }

    public TrainingsSummary getTrainingsSummaryByDayId (Long dayId){
        List<TrainingDto> trainingsDto = listTrainingToListDtoConverter.mappingList(getTrainingsByDayId(dayId));
        return trainingsSummaryCreator.createTrainingsSummary(trainingsDto);
    }

    public List<TrainingDto> getAllTrainingsDto (){
        return listTrainingToListDtoConverter.mappingList(getAllTrainings());
    }

    public String addTrainingByDto (TrainingDto trainingDto){
        addTraining(dtoToTrainingConverter.mappingEntity(trainingDto));
        return "Przesłany trening został zapisany w bazie danych";
    }

    public String updateTrainingByDto (TrainingDto trainingDto){
        updateTraining(dtoToTrainingConverter.mappingEntity(trainingDto));
        return "Przesłany trening został uaktualniony";
    }

    public String deleteTraining (Long id){
        deleteTrainingById(id);
        return "Trening o przesłanym id została usuniety";
    }
}
