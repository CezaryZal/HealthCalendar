package com.CezaryZal.api.shortday.entity;

import java.time.LocalDate;

public class ShortDayDto extends FormShortDay{

    public ShortDayDto(
            Long id,
            Long userId,
            LocalDate date,
            boolean isAchievedKcal,
            boolean isAchievedDrink,
            boolean isAlcohol,
            boolean isSnacks) {
        super(id, userId, date, isAchievedKcal, isAchievedDrink, isAlcohol, isSnacks);
    }
}
