package com.CezaryZal.api.day.entity.api;

import com.CezaryZal.api.day.entity.FormDay;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class DayApi extends FormDay {

    private String nick;
    private LocalDate lastDateMeasureBody;
    private boolean isAchievedDrink;
    private boolean isAchievedKcal;

    public DayApi(
            Long id,
            LocalDate date,
            Long userId,
            int portionsDrink,
            int portionsAlcohol,
            int portionsSnack,
            String nick,
            LocalDate lastDateMeasureBody,
            boolean isAchievedDrink,
            boolean isAchievedKcal) {
        super(id, date, userId, portionsDrink, portionsAlcohol, portionsSnack);
        this.nick = nick;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.isAchievedDrink = isAchievedDrink;
        this.isAchievedKcal = isAchievedKcal;
    }
}
