package com.CezaryZal.api.training;

import com.CezaryZal.exceptions.not.found.TrainingNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainingService {

    private TrainingRepository trainingR;

    public TrainingService(TrainingRepository TRepository) {
        this.trainingR = TRepository;
    }

    public Training getTrainingById (Long id){
        return trainingR.findById(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training not found by id"));
    }

    public TrainingsDTO getTrainingsDTOByDayId (Long dayId){
        List<Training> listTraining = trainingR.findAllByDayId(dayId);

        return createAllTrainingsDTOByDay(listTraining);
    }

    public List<Training> getAllTrainings (){
        return (List<Training>) trainingR.findAll();
    }

    public void addTraining (Training training){
        trainingR.save(training);
    }

    public void updateTraining (Training training){
        trainingR.save(training);
    }

    public void deleteTrainingById (Long id){
        trainingR.deleteById(id);
    }

    public TrainingsDTO createAllTrainingsDTOByDay(List<Training> listTraining){
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = LocalTime.of(0,0);
        for (Training training : listTraining) {
            if (training != null) {
                sumOfBurnKcal += training.getBurnKcal();
                long hour = training.getElapsedTime().getHour();
                long minute = training.getElapsedTime().getMinute();
                sumOfTimes = sumOfTimes.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(minute));
            }
        }
        return new TrainingsDTO(listTraining, sumOfBurnKcal, sumOfTimes);
    }
}
