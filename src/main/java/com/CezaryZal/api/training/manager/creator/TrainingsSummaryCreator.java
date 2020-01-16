package com.CezaryZal.api.training.manager.creator;

import com.CezaryZal.api.training.entity.TrainingDto;
import com.CezaryZal.api.training.entity.TrainingsSummary;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainingsSummaryCreator {

    public TrainingsSummary createTrainingsSummary(List<TrainingDto> listTraining){
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = LocalTime.of(0,0);

        for (TrainingDto training : listTraining) {
            if (training != null) {
                sumOfBurnKcal += training.getBurnKcal();
                long hour = training.getElapsedTime().getHour();
                long minute = training.getElapsedTime().getMinute();
                sumOfTimes = sumOfTimes.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(minute));
            }
        }
        return new TrainingsSummary(listTraining, sumOfBurnKcal, sumOfTimes);
    }
}
