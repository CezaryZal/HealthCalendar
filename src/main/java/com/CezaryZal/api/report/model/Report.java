package com.CezaryZal.api.report.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class Report extends FormReport {

    public Report(Long id, LocalDate date,
                  Long userId,
                  int portionsDrink,
                  int portionsAlcohol,
                  int portionsSnack, String nick,
                  LocalDate lastDateMeasureBody,
                  boolean isAchievedDrink,
                  boolean isAchievedKcal) {
        super(id,
                date,
                userId,
                portionsDrink,
                portionsAlcohol,
                portionsSnack,
                nick,
                lastDateMeasureBody,
                isAchievedDrink,
                isAchievedKcal);
    }
}
