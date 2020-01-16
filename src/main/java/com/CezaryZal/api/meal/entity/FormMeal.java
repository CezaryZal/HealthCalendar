package com.CezaryZal.api.meal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormMeal {

    private Long id;
    private LocalDateTime dateTimeOfEat;
    private String type;
    private int kcal;
    private String description;
    private Long dayId;
}
