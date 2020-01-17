package com.CezaryZal.api.shortday.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormShortDay {

    private Long id;
    private Long userId;
    private LocalDate date;
    private boolean isAchievedKcal;
    private boolean isAchievedDrink;
    private boolean isAlcohol;
    private boolean isSnacks;
}
