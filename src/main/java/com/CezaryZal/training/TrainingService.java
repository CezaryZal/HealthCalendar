package com.CezaryZal.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service
public class TrainingService {

    private TrainingRepository TrainingR;

    @Autowired
    public TrainingService(TrainingRepository TRepository) {
        this.TrainingR = TRepository;
    }

    public TrainingDB findById (int id){
        TrainingDB trainingDB = TrainingR.findById(id);

        return trainingDB;
    }

    public AllTrainingsByDay getTrainingsByDay (int dayId){
        List<TrainingDB> listTrainingDB = TrainingR.findByDayId(dayId);
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = LocalTime.of(0,0);
        for (TrainingDB trainingDB : listTrainingDB) {
            if (trainingDB != null) {
                sumOfBurnKcal += trainingDB.getBurnKcal();
                long hour = trainingDB.getTime().getHour();
                long minute = trainingDB.getTime().getMinute();
                sumOfTimes = sumOfTimes.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(minute));
            }
        }
        AllTrainingsByDay trainingsByDay = new AllTrainingsByDay(listTrainingDB, sumOfBurnKcal, sumOfTimes);

        return trainingsByDay;
    }

    public List<TrainingDB> getAll (){
        List<TrainingDB> listMealDB = TrainingR.getAll();

        return listMealDB;
    }

    public boolean addTraining (TrainingDB trainingDB){
        TrainingR.save(trainingDB);

        return true;
    }

    public boolean updateTraining (TrainingDB trainingDB){
        TrainingR.update(trainingDB);

        return true;
    }

    public String deleteTrainingById (int id){
        TrainingDB trainingDB = TrainingR.findById(id);
        if(TrainingR.delete(trainingDB)){
            return "delete record";
        }
        return "Training id not found";
    }
}
