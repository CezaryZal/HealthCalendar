package com.CezaryZal.api.training.manager.repo;

import com.CezaryZal.api.training.TrainingRepository;
import com.CezaryZal.api.training.model.entity.Training;
import com.CezaryZal.exceptions.not.found.TrainingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingRepoService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingRepoService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training getTrainingById (Long id){
        return trainingRepository.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training not found by id"));
    }

    public List<Training> getTrainingsByDayId (Long dayId){
        return trainingRepository.findAllByDayId(dayId)
                .orElseThrow(() -> new TrainingNotFoundException("Trainings not found by id"));
    }

    public List<Training> getAllTrainings (){
        return trainingRepository.findAll();
    }

    public void addTraining (Training training){
        trainingRepository.save(training);
    }

    public void updateTraining (Training training){
        trainingRepository.save(training);
    }

    public void deleteTrainingById (Long id){
        trainingRepository.deleteById(id);
    }
}
