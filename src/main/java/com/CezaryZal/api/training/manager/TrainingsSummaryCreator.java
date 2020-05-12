package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainingsSummaryCreator {

    TrainingsSummary createTrainingsSummary(List<ApiEntityDto> apiEntityDtos) {
        int sumOfBurnKcal = 0;
        LocalTime sumOfTimes = LocalTime.of(0, 0);
        if (!apiEntityDtos.isEmpty()) {
            for (ApiEntityDto apiEntityDto : apiEntityDtos) {
                TrainingDto training = (TrainingDto)apiEntityDto;
                sumOfBurnKcal += training.getBurnKcal();
                long hour = training.getElapsedTime().getHour();
                long minute = training.getElapsedTime().getMinute();
                sumOfTimes = sumOfTimes.plus(Duration.ofHours(hour)).plus(Duration.ofMinutes(minute));
            }
        }
        return new TrainingsSummary(apiEntityDtos, sumOfBurnKcal, sumOfTimes);
    }
}
