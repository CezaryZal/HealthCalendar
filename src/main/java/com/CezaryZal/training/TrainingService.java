package com.CezaryZal.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

//@Transactional
@Service
public class TrainingService {

    private TrainingRepository TrainingR;

    @Autowired
    public TrainingService(TrainingRepository TRepository) {
        this.TrainingR = TRepository;
    }

    public Training getTrainingById (int id){
        return TrainingR.findById(id);
    }

    public AllTrainingsDTO getTrainingsDTOByDayId (int dayId){
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

    public String deleteTrainingById (int id){
        Training training = TrainingR.findById(id);
        if(TrainingR.delete(training)){
            return "delete record";
        }
        return "Training id not found";
    }

    public AllTrainingsDTO createAllTrainingsDTOByDay(List<Training> listTraining){
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
        return new AllTrainingsDTO(listTraining, sumOfBurnKcal, sumOfTimes);
    }
}
