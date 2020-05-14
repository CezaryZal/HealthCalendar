package com.CezaryZal.api.training.model;

import com.CezaryZal.api.ApiEntityDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class TrainingsSummary {

    private final List<ApiEntityDto> listTrainings;

    private final int sumOfBurnKcal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private final LocalTime sumOfTimes;

}
