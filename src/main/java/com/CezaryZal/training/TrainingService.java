package com.CezaryZal.training;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainingService {

    private TrainingRepository TrainingR;

    public TrainingService(TrainingRepository TRepository) {
        this.TrainingR = TRepository;
    }

    public Training getTrainingById (Long id){
        return TrainingR.findById(id);
    }

    public TrainingsDTO getTrainingsDTOByDayId (Long dayId){
        List<Training> listTraining = TrainingR.findByDayId(dayId);

        return createAllTrainingsDTOByDay(listTraining);
    }

    public List<Training> getAllTrainings (){
        return TrainingR.getAll();
    }

    public boolean addTraining (Training training){
        TrainingR.save(training);

        return true;
    }

    public boolean updateTraining (Training training){
        TrainingR.update(training);

        return true;
    }

    public String deleteTrainingById (Long id){
        Training training = TrainingR.findById(id);
        if(TrainingR.delete(training)){
            return "delete record";
        }
        return "Training id not found";
    }

    public TrainingsDTO createAllTrainingsDTOByDay(List<Training> listTraining){
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = LocalTime.of(0,0);
        for (Training training : listTraining) {
            if (training != null) {
                sumOfBurnKcal += training.getBurnKcal();
                long hour = training.getTime().getHour();
                long minute = training.getTime().getMinute();
                sumOfTimes = sumOfTimes.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(minute));
            }
        }
        return new TrainingsDTO(listTraining, sumOfBurnKcal, sumOfTimes);
    }
}
