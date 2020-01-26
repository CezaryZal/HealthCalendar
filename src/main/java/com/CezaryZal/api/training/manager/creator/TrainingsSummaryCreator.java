package com.CezaryZal.api.training.manager.creator;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainingsSummaryCreator {

    public TrainingsSummary createTrainingsSummary(List<TrainingDto> listTraining) {
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = LocalTime.of(0, 0);
        if (!listTraining.isEmpty()) {
            for (TrainingDto training : listTraining) {
                sumOfBurnKcal += training.getBurnKcal();
                long hour = training.getElapsedTime().getHour();
                long minute = training.getElapsedTime().getMinute();
                sumOfTimes = sumOfTimes.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(minute));
            }
        }
        return new TrainingsSummary(listTraining, sumOfBurnKcal, sumOfTimes);
    }
}
