package com.CezaryZal.api.training.manager.repo;

import com.CezaryZal.api.training.TrainingRepository;
import com.CezaryZal.api.training.entity.Training;
import com.CezaryZal.exceptions.not.found.TrainingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainingRepoService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingRepoService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    protected Training getTrainingById (Long id){
        return trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training not found by id"));
    }

    protected List<Training> getTrainingsByDayId (Long dayId){
        return trainingRepository.findAllByDayId(dayId);
    }

    protected List<Training> getAllTrainings (){
        return trainingRepository.findAll();
    }

    protected void addTraining (Training training){
        trainingRepository.save(training);
    }

    protected void updateTraining (Training training){
        trainingRepository.save(training);
    }

    protected void deleteTrainingById (Long id){
        trainingRepository.deleteById(id);
    }
}
