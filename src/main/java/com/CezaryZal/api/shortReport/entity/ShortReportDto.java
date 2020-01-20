package com.CezaryZal.api.shortReport.entity;

import java.time.LocalDate;

public class ShortReportDto extends FormShortReport {

    public ShortReportDto(
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
