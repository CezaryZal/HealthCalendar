package com.CezaryZal.api.training.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormTraining {

    private Long id;
    private LocalDateTime dateTimeOfExecution;
    private String description;
    private LocalTime elapsedTime;
    private int burnKcal;
    private Long dayId;
}
