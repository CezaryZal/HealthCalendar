package com.CezaryZal.api.day.entity.day;

import com.CezaryZal.api.day.entity.FormDay;

import java.time.LocalDate;

public class DayBasic extends FormDay {

    public DayBasic(
            Long id,
            LocalDate date,
            Long userId,
            int portionsDrink,
            int portionsAlcohol,
            int portionsSnack) {
        super(id, date, userId, portionsDrink, portionsAlcohol, portionsSnack);
    }
}
