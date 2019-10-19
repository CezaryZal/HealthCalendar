package com.CezaryZal.training;


import com.CezaryZal.training.trainingsByDay.AllTrainingsByDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.datatype.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service
public class TrainingService {

    private TrainingRepository TRepository;

    @Autowired
    public TrainingService(TrainingRepository TRepository) {
        this.TRepository = TRepository;
    }

    public TrainingDB findById (int id){
        TrainingDB trainingDB = TRepository.findById(id);

        return trainingDB;
    }

    public AllTrainingsByDay getTrainingsByDay (String  inputDate, int dayId){
        LocalDate localDate = LocalDate.parse(inputDate);
        List<TrainingDB> listTrainingDB = TRepository.findByDateAndDayId(localDate, dayId);
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = null;
        for (TrainingDB trainingDB : listTrainingDB){
            sumOfBurnKcal += trainingDB.getBurnKcal();
            sumOfTimes.plus(trainingDB.getTime());
        }
        AllTrainingsByDay trainingsByDay = new AllTrainingsByDay(listTrainingDB, sumOfBurnKcal, sumOfTimes);

        return trainingsByDay;
    }

    public List<TrainingDB> getAll (){
        List<TrainingDB> listMealDB = TRepository.getAll();

        return listMealDB;
    }

    public boolean addTraining (TrainingDB trainingDB){
        TRepository.save(trainingDB);

        return true;
    }

    public boolean updateTraining (TrainingDB trainingDB){
        TRepository.update(trainingDB);

        return true;
    }

    public String deleteTrainingById (int id){
        TrainingDB trainingDB = TRepository.findById(id);
        if(TRepository.delete(trainingDB)){
            return "delete record";
        }
        return "Diet id not found";
    }
}
