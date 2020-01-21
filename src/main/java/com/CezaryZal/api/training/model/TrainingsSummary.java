package com.CezaryZal.api.training.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class TrainingsSummary {

    private List<TrainingDto> listTrainings;
    private int sumOfBurnKcal;
    private LocalTime sumOfTimes;

}
