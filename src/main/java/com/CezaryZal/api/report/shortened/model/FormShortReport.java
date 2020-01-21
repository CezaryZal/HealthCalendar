package com.CezaryZal.api.report.shortened.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormShortReport {

    private Long id;
    private Long userId;
    private LocalDate date;
    private boolean isAchievedKcal;
    private boolean isAchievedDrink;
    private boolean isAlcohol;
    private boolean isSnacks;
}
