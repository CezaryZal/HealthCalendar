package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import com.CezaryZal.api.training.model.TrainingsSummary;
import com.CezaryZal.api.training.repo.TrainingRepository;
import com.CezaryZal.exceptions.not.found.TrainingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final TrainingConverter trainingConverter;
    private final TrainingsSummaryCreator trainingsSummaryCreator;
    private final TrainingCreator trainingCreator;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository,
                           TrainingConverter trainingConverter,
                           TrainingsSummaryCreator trainingsSummaryCreator,
                           TrainingCreator trainingCreator) {
        this.trainingRepository = trainingRepository;
        this.trainingConverter = trainingConverter;
        this.trainingsSummaryCreator = trainingsSummaryCreator;
        this.trainingCreator = trainingCreator;
    }

    public TrainingDto getTrainingDtoById (Long id){
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training not found by id"));
        return trainingConverter.mappingTrainingToDto(training);
    }

    public TrainingsSummary getTrainingsSummaryByDayId (Long dayId){
        List<Training> trainings = trainingRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new TrainingNotFoundException("Trainings not found by id"));
        return getTrainingsSummaryByTrainings(trainings);
    }

    public TrainingsSummary getTrainingsSummaryByTrainings(List<Training> trainingsByDayId){
        List<TrainingDto> trainingsDto = trainingConverter.mappingListTrainingToListDto(trainingsByDayId);
        return trainingsSummaryCreator.createTrainingsSummary(trainingsDto);
    }

    public List<TrainingDto> getAllTrainingsDto (){
        return trainingConverter.mappingListTrainingToListDto(trainingRepository.findAll());
    }

    public String addTrainingByDto (TrainingDto trainingDto){
        trainingRepository.save(trainingCreator.createTrainingByDtoAndId(trainingDto));
        return "Przesłany trening został zapisany w bazie danych";
    }

    public String updateTrainingByDto (TrainingDto trainingDto, Long trainingId){
        trainingRepository.save(trainingCreator.createTrainingToUpdateByDtoAndId(trainingDto, trainingId));
        return "Przesłany trening został uaktualniony";
    }

    public String deleteTraining (Long id){
        trainingRepository.deleteById(id);
        return "Trening o przesłanym id została usuniety";
    }
}
